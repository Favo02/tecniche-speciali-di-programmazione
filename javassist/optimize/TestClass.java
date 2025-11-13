public class TestClass {

    public int add(int a) {
        return a + 0;
    }

    public int mult(int a) {
        return a * 2;
    }

    public int add2(int a) {
        return 0 + a;
    }

    // using javassist nop must be placed, so its harder to optimize
    // when there are nop placed in the middle
    public int crazy(int a, int b) {
        return 0 + (a * 2) + (b + 0);
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        System.out.println(tc.add(5));
        System.out.println(tc.mult(5));
        System.out.println(tc.add2(9));
        System.out.println(tc.crazy(5, 6));
    }

}
