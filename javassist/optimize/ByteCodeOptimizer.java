import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.*;
import javassist.tools.reflect.Loader;

import java.util.*;

public class ByteCodeOptimizer {

    private final static Map<List<Integer>, List<Integer>> optimizations = new HashMap<>();

    public static void main(String[] args) throws Exception {

        optimizations.put(List.of(Opcode.ICONST_0, Opcode.IADD), List.of(Opcode.NOP, Opcode.NOP));
        optimizations.put(List.of(Opcode.ICONST_2, Opcode.IMUL), List.of(Opcode.ICONST_1, Opcode.ISHL));
        optimizations.put(List.of(Opcode.ICONST_0, Opcode.ILOAD_1, Opcode.IADD),
                List.of(Opcode.ILOAD_1, Opcode.NOP, Opcode.NOP));

        // using javassist methods bytecode cannot be shortened, so each optimization
        // should be the same length of its optimized bytecode
        for (var key : optimizations.keySet()) {
            if (optimizations.get(key).size() != key.size())
                System.out.println("Invalid optimization: " + key);
            continue;
        }

        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.get(args[0]);
        for (var m : clazz.getDeclaredMethods()) {
            while (optimizeMethod(m)) {
            }
        }

        clazz.writeFile("optimized");
    }

    public static boolean optimizeMethod(CtMethod method) throws BadBytecode {
        boolean optimized = false;
        CodeAttribute codeAttribute = method.getMethodInfo().getCodeAttribute();

        System.out.println("-----> BEFORE " + method.getName());
        printBytecode(codeAttribute);

        for (var opt : optimizations.keySet()) {

            CodeIterator iterator = codeAttribute.iterator();
            while (iterator.hasNext()) {
                int index = iterator.next();
                int optsize = optimizations.get(opt).size();
                if (index < optsize)
                    continue;

                boolean targeted = true;
                for (int i = 0; i < optsize; i++) {
                    if (iterator.byteAt(index - optsize + i) != opt.get(i)) {
                        targeted = false;
                    }
                }

                if (targeted) {
                    for (int i = 0; i < optsize; i++) {
                        iterator.writeByte(optimizations.get(opt).get(i), index - optsize + i);
                    }
                    break;
                }
                index++;
            }
        }

        System.out.println("-----> AFTER " + method.getName());
        printBytecode(codeAttribute);

        return optimized;
    }

    public static void printBytecode(CodeAttribute ca) {
        for (var code : ca.getCode()) {
            System.out.println(Mnemonic.OPCODE[code & 0xff]);
        }
        System.out.println();
    }
}
