import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;

public class DepthHandler extends NestedCalls implements InvocationHandler {

    private int depth;

    public DepthHandler() {
        depth = 0;
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
        try {
            return (int) invoke(this, DepthHandler.class.getMethod("a", new Class[0]), new Object[0]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int b(int a) {
        try {
            return (int) invoke(this, DepthHandler.class.getMethod("b", new Class[] { int.class }), new Object[] { a });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int c(int a) {
        try {
            return (int) invoke(this, DepthHandler.class.getMethod("c", new Class[] { int.class }), new Object[] { a });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

}
