public class Main {
    public static void main(String[] args) {
        Caller a = new A();
        Caller b = new B();
        Caller c = new C();

        System.out.println("--- Executing b() -> c() -> a()");
        b.setNext(c);
        c.setNext(a);
        b.call();

        System.out.println("--- Executing c() -> b() -> a()");
        c.setNext(b);
        b.setNext(a);
        c.call();
    }
}
