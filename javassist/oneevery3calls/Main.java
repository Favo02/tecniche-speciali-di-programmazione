public class Main {
    public static void main(String[] args) {

        Cane pluto = new Cane("Pluto");
        Cane gio = new Cane("Gio");
        pluto.bau((Integer) 0);
        gio.bau(0);
        pluto.bau(0.0);
        pluto.bau((Number) 0);
        pluto.bau(0);
        pluto.bau(42);
        gio.bau(0);
        pluto.bau(0);
        gio.bau(0);

    }
}
