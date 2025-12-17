public class Incrocio {

    private String name;
    private Semaforo[] semafori;

    public Incrocio(String name, Semaforo[] semafori) {
        this.name = name;
        this.semafori = semafori;
    }

    public void go() {
        for (Semaforo semaforo : semafori) {
            semaforo.go();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " [ ");
        for (Semaforo semaforo : semafori) {
            sb.append(semaforo.getColore() + " ");
        }
        sb.append("]");
        return sb.toString();
    }

}
