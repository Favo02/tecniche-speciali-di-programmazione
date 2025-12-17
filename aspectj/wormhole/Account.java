public class Account {
    private int total;
    private String owner;

    public Account(String o) {
        owner = o;
        total = 0;
    }

    public void deposit(int euro) {
        System.out.println("*** deposit()");
        total += euro;
    }

    public void withdraw(int euro) {
        System.out.println("*** withdraw()");
        total -= euro;
    }

    public int balance() {
        System.out.println("*** balance()");
        return total;
    }

    public String toString() {
        return "CC(" + owner + ") :- " + total;
    }
}
