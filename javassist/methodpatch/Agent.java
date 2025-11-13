import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMember;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.bytecode.ClassFile;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class Agent {

    private static void transformPuffo(CtClass clazz) throws Throwable {
        System.out.println("[Agent] Transforming Puffo...");

        CtMethod mth = CtNewMethod.make("public String puf() { return \"patched puf\"; }", clazz);
        clazz.addMethod(mth);

        clazz.getDeclaredMethod("puffa").setBody("System.out.println(\"PATCHED PUFFO\");");
    }

    public static void premain(String cn, Instrumentation instr) {

        instr.addTransformer(new ClassFileTransformer() {

            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                    ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                try {
                    ClassPool pool = ClassPool.getDefault();
                    CtClass clazz = pool.makeClass(new ByteArrayInputStream(classfileBuffer));

                    if (className.equals("Puffo")) {
                        transformPuffo(clazz);
                    }

                    if (className.equals("Main")) {
                        // this pre-transforms the class Puffo to let main compile successfully
                        // but this is only a local modification, will not be reflected on puffo.
                        // Puffo will be loaded normally (it will be modified independently
                        // when it gets loaded, lines above)
                        transformPuffo(pool.get("Puffo"));

                        System.out.println("[Agent] Transforming Main...");

                        // doesnt work, cannot access local fields in insert
                        // clazz.getDeclaredMethod("main").insertAfter("System.out.println(p.puf());");

                        CtMethod m = clazz.getDeclaredMethod("main");
                        m.instrument(new ExprEditor() {
                            public void edit(MethodCall m) throws javassist.CannotCompileException {
                                if (m.getMethodName().equals("puffa")) {
                                    m.replace("{ $proceed($$); System.out.println($0.puf()); }");
                                }
                            }
                        });
                    }

                    return clazz.toBytecode();

                } catch (Throwable e) {
                    System.out.println(e);
                }

                return ClassFileTransformer.super.transform(loader, className, classBeingRedefined, protectionDomain,
                        classfileBuffer);
            }

        });

    }

}
