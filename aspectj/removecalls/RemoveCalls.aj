import java.util.Hashtable;

public aspect RemoveCalls {

    pointcut aCall() : target(A) && call(* *.call(..));

    Object around() : aCall() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        for (StackTraceElement el : stack) {
            if (el.getClassName().equals("B")) {
                // allow the call
                break;
            }
            if (el.getClassName().equals("C")) {
                // prevent execution by skipping proceed()
                return null;
            }
        }

        return proceed();
    }
}
