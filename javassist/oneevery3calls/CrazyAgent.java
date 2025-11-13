import java.lang.instrument.Instrumentation;

import javassist.tools.reflect.Loader;

public class CrazyAgent {

    public static void premain(String classname, Instrumentation instr) throws Exception {
        Loader cl = new Loader();
        cl.makeReflective("Cane", "CallsFilterer", "javassist.tools.reflect.ClassMetaobject");
    }

}
