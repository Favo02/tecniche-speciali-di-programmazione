public class Main {

    public static void main(String[] args) {

        Incrocio tre = new Incrocio("Tre vie", new Semaforo[] {
                new Semaforo(),
                new Semaforo(),
                new Semaforo()
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(tre);
            tre.go();
        }

        Incrocio quattro = new Incrocio("Quattro vie", new Semaforo[] {
                new Semaforo(),
                new Semaforo(),
                new Semaforo(),
                new Semaforo()
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(quattro);
            quattro.go();
        }

    }

}
