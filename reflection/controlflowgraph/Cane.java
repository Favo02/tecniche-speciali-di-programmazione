public class Cane {

    private final String name;

    public Cane(String name) {
        this.name = name;
    }

    @CFG(calls = { "Formatter.format", "Formatter.write" })
    public String giovanni() {
        Formatter f = new Formatter("--");
        f.format(this.name);
        return f.write();
    }

}
