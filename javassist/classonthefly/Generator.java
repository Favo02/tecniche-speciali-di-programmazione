import java.lang.reflect.Modifier;

import javassist.*;

public class Generator {

    public static void genPerson() throws Exception {

        ClassPool pool = ClassPool.getDefault();
        CtClass person = pool.makeClass("Person");

        person.addField(CtField.make("private final String name;", person));
        person.addField(CtField.make("private final int birth;", person));
        person.addConstructor(CtNewConstructor
                .make("public Person(String name, int birth) { this.name = name; this.birth = birth; }",
                        person));
        person.addMethod(CtNewMethod.make("public int age() { return 2025 - this.birth; }", person));
    }

    public static void genTestPerson() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass test = pool.makeClass("TestPerson");

        CtMethod m = CtMethod.make(
                "public static void main(String[] args) { Person p = new Person(\"Luca\", 2002); System.out.println(p.age()); }",
                test);
        test.addMethod(m);
    }

}
