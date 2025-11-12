import java.lang.reflect.Field;

import javassist.tools.reflect.*;

public class VerboseMetaobject extends Metaobject {

    public VerboseMetaobject(Object self, Object[] args) {
        super(self, args);
        System.out.println("** constructed: " + self.getClass().getName());
    }

    @Override
    public Object trapFieldRead(String name) {
        System.out.println("** field read: " + name);
        return super.trapFieldRead(name);
    }

    @Override
    public void trapFieldWrite(String name, Object value) {
        System.out.println("** field write: " + name);
        super.trapFieldWrite(name, value);
    }

    @Override
    public Object trapMethodcall(int identifier, Object[] args) throws Throwable {
        System.out.println("** trap: " + getMethodName(identifier) + "() in " + getClassMetaobject().getName());

        Class<?> clazz = Class.forName("TestingFields");
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + ": " + f.get(this.getObject()));

        }

        return super.trapMethodcall(identifier, args);
    }

}
