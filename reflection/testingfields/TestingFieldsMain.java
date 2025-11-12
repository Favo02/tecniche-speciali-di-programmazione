import java.lang.reflect.Field;

public class TestingFieldsMain {
    public static void main(String[] args) {
        try {
            TestingFields test = new TestingFields(7, 3.14);
            Class<?> cls = test.getClass();

            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                System.out.println(field.get(test));
                if (field.getName().equals("s")) {
                    field.set(test, "PUFFo");
                }
            }

            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                System.out.println(field.get(test));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
