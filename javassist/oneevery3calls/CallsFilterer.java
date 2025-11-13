import java.util.*;

import javassist.tools.reflect.Metaobject;

public class CallsFilterer extends Metaobject {

    private Map<String, Integer> calls = new HashMap<>();

    public CallsFilterer(Object self, Object[] args) {
        super(self, args);
    }

    public Object trapMethodcall(int identifier, Object[] args) throws Throwable {
        if (getMethodName(identifier).equals("getName")) {
            return super.trapMethodcall(identifier, args);
        }

        String signature = getMethodName(identifier) + "(" + Arrays.toString(getParameterTypes(identifier)) + ")";
        calls.put(signature, (calls.getOrDefault(signature, 0) + 1) % 3);

        System.out
                .println("** " + ((Cane) this.getObject()).getName() + ": " + signature + "): " + calls.get(signature));
        if (calls.get(signature) == 0)
            return super.trapMethodcall(identifier, args);
        return null;
    }

}
