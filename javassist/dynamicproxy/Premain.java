import javassist.tools.reflect.Loader;

public class Premain {

    public static void premain(String args) throws Throwable {
        Loader load = new Loader();
        load.makeReflective("TestingFields", "VerboseMetaobject", "javassist.tools.reflect.ClassMetaobject");
    }

}
