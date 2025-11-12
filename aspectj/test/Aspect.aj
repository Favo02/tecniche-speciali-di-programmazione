public aspect Aspect {
    pointcut ends(): execution(public static void *.main(..));

    after(): ends() {
        System.out.println("CRAZY");
    }
}
