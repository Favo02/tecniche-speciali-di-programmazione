public class Main {
    public static void main(String[] args) {
        TestingFields ts = new TestingFields(4, 4.2);
        System.out.println(ts);
        ts.setAnswer(10);
        System.out.println(ts);

        TestingFields ts2 = new TestingFields(4, 4.2);
        System.out.println(ts2);
        ts2.setAnswer(11);
        System.out.println(ts2);
    }
}
