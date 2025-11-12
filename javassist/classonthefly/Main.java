import javassist.*;

public class Main {
    public static void main(String[] args) {

        try {
            Generator.genPerson();
            Generator.genTestPerson();

            ClassPool pool = ClassPool.getDefault();
            Loader load = new Loader(pool);
            load.loadClass("Person");
            load.run("TestPerson", null);

        } catch (Throwable e) {
            System.out.println("ERRORE" + e);
            System.out.println(e.getMessage());
        }
    }
}
