import java.util.Hashtable;

public class ATM {

    private int number;
    private static Hashtable<String, Account> cc = new Hashtable<String, Account>();

    public ATM(int mat) {
        number = mat;
    }

    public void deposit(String o, int amount) {
        cc.get(o).deposit(amount);
    }

    public void withdraw(String o, int amount) {
        cc.get(o).withdraw(amount);
    }

    public int balance(String o) {
        return cc.get(o).balance();
    }

    public String toString() {
        return "ATM " + number + ": ";
    }

    static {
        cc.put("Walter", new Account("Walter"));
        cc.put("Cazzola", new Account("Cazzola"));
        cc.put("Walter Cazzola", new Account("Walter Cazzola"));
    }
}
