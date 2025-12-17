public aspect PaymentChecker {

    pointcut pay(String name, double amt):
        execution(* PaymentService.processPayment(..)) && args(name, amt);

    void around(String name, double amt): pay(name, amt) {
        if (name.equals("VIP")) {
            System.out.println("Instant VIP transfer for $" + amt);
            return;
        }
        if (name.equals("Banned")) {
            System.out.println("Transaction blocked for Banned user");
            return;
        }
        proceed(name, amt);
    }

}
