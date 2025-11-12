import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DumpMethods {
    public static void main(String[] args) {
        Arrays.stream(args)
                .forEach(arg -> {
                    try {
                        System.out.println(String.format("--- %s ---", arg));
                        Arrays.stream(Class.forName(arg).getMethods())
                                .map(mth -> String.format("%s %s %s(%s)",
                                        Modifier.toString(mth.getModifiers()),
                                        mth.getReturnType().getSimpleName(),
                                        mth.getName(),
                                        Arrays.stream(mth.getParameterTypes())
                                                .map(p -> p.getSimpleName())
                                                .collect(Collectors.joining(", "))))
                                .forEach(System.out::println);
                        System.out.println("------");
                    } catch (ClassNotFoundException e) {
                        System.out.println(String.format("Class %s not found", arg));
                    }
                });
    }
}
