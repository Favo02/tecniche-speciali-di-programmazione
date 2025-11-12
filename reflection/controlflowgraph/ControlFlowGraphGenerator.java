import java.lang.reflect.Method;

public class ControlFlowGraphGenerator {
    public static void main(String[] args) {

        for (String name : args) {
            System.out.println("ANALYZING CLASS " + name + "...");

            try {
                Class<?> clazz = Class.forName(name);

                for (Method mth : clazz.getDeclaredMethods()) {
                    if (!mth.isAnnotationPresent(CFG.class))
                        continue;

                    CFG annotation = mth.getAnnotation(CFG.class);

                    for (String call : annotation.calls()) {
                        System.out.println(String.format("%s.%s -> %s", name, mth.getName(), call));
                    }
                }

            } catch (ClassNotFoundException e) {
                System.out.println(String.format("ERROR: class \"%s\" not found", name));
            }
        }

    }
}
