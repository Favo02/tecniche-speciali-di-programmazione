import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InvokeUnknownMethod {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName(args[0]);
            Object[] pars = parseParameters(args);

            Method mth = cls.getMethod(args[1],
                    Arrays.stream(pars)
                            .map(o -> primitiveType(o.getClass()))
                            .toList()
                            .toArray(new Class<?>[0]));
            Constructor<?> con = cls.getConstructor();
            Object instance = con.newInstance();
            System.out.println(mth.invoke(instance, pars));

        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Class %s not found", args[0]));
        } catch (NoSuchMethodException e) {
            System.out.println(String.format("Method %s not found", args[1]));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static Number toNumber(String n) {
        if (n.contains("."))
            return Double.parseDouble(n);
        return Integer.parseInt(n);
    }

    private static Class<?> primitiveType(Class<?> c) {
        switch (c.getSimpleName()) {
            case "Integer":
                return int.class;
            case "Double":
                return double.class;
        }
        return null;
    }

    private static Object[] parseParameters(String[] args) {
        return Arrays
                .stream(args)
                .skip(2)
                .map(a -> toNumber(a))
                .toArray();
    }
}
