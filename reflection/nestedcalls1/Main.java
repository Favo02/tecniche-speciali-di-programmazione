import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        INestedCalls nc = new NestedCalls();

        INestedCalls pnc = (INestedCalls) Proxy.newProxyInstance(NestedCalls.class.getClassLoader(),
                NestedCalls.class.getInterfaces(), new DepthHandler());

        pnc.a();
    }
}
