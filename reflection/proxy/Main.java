import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        ITestingFields tf = new TestingFields(5, 4.2);

        ITestingFields proxy = (ITestingFields) Proxy.newProxyInstance(
                ITestingFields.class.getClassLoader(),
                tf.getClass().getInterfaces(),
                new LoggerHandler(tf));

        System.out.println(proxy.message());

    }
}
