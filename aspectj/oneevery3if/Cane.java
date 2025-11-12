public class Cane {

    private final String name;

    public Cane(String name) {
        this.name = name;
    }

    public void bau(boolean a) {
        if (a) {
            System.out.println(name + " abbaia!");
        }
    }

    public void miao(boolean a) {
        if (a) {
            System.out.println(name + " miagola!");
        }
    }

}
