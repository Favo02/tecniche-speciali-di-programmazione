import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerHandler implements InvocationHandler {

    private final Object instance;

    public LoggerHandler(Object instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> clazz = instance.getClass();

        System.out.println("-- before --");
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(String.format("%s : %s", f.getName(), f.get(instance)));
        }

        Object res = method.invoke(this.instance, args);

        System.out.println("-- after --");
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(String.format("%s : %s", f.getName(), f.get(instance)));
        }
        System.out.println("-- --");
        return res;
    }

}
