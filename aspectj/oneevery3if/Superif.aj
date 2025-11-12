import java.util.*;

public aspect Superif perthis(ogniif()) {

    private Map<String, Integer> countPerMethod = new HashMap<>();

    pointcut ogniif() :
        within(Cane) &&
        execution(* *(..));

    pointcut ifvero() :
        !within(Superif) &&
        call(void java.io.PrintStream.println(String));

    Object around() : ifvero() && cflow(ogniif()) {
        String method = new Throwable().getStackTrace()[1].getMethodName();
        countPerMethod.put(method, (countPerMethod.getOrDefault(method, 0) + 1) % 3);

        System.out.println(method + countPerMethod.get(method));

        if (countPerMethod.get(method) == 0) {
            return proceed();
        }
        return null;
    }

}
