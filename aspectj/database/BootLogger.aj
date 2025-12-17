public aspect BootLogger {

    pointcut connect():
        call(* Database.connect(..));

    pointcut inBoot():
        call(* SystemBoot.startUp(..));

    before(): connect() && cflow(inBoot()) {
        System.out.println(">> [BOOT SEQUENCE] Initiating DB connection...");
    }

}
