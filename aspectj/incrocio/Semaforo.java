public class Semaforo {

    public enum Colore {
        Verde, Giallo, Rosso;

        public Colore next() {
            return values()[(this.ordinal() + 1) % values().length];
        }
    }

    private Colore colore = Colore.Verde;

    public void go() {
        colore = colore.next();
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }

}
