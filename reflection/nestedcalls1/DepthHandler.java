import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;

public class DepthHandler extends NestedCalls implements InvocationHandler {

    private final INestedCalls proxy;
    private int depth;

    public DepthHandler() {
        depth = 0;
        proxy = (INestedCalls) Proxy.newProxyInstance(NestedCalls.class.getClassLoader(),
                NestedCalls.class.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        depth++;
        Method mth = NestedCalls.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
        MethodHandle mthhan = MethodHandles.lookup().unreflectSpecial(mth, getClass());
        System.out.println("calling " + method.getName() + " at depth " + depth);
        Object res = mthhan.bindTo(this).invokeWithArguments(args);
        depth--;
        return res;
    }

    @Override
    public int a() {
        return proxy.a();
    }

    @Override
    public int b(int a) {
        return proxy.b(a);
    }

    @Override
    public int c(int a) {
        return proxy.c(a);
    }

}
