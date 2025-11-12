public class ResourceWaster {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Resource ra1 = new RA();
        Resource ra2 = new RA();

        Resource rb1 = new RB();
        Resource rb2 = new RB();

        Resource rc1 = new RC();
        Resource rc2 = new RC();

        ra1.destroy();

        Resource rb3 = new RB();

        rb1.destroy();

        Resource rb4 = new RB();

        rc1.destroy();

        rb2.destroy();

        rb3.destroy();

        Resource ra3 = new RA();

        Resource rb5 = new RB();

    }

}
