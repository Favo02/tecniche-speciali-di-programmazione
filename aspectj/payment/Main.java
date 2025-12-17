public class Main {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        ps.processPayment("Alice", 50.0); // Standard
        ps.processPayment("Banned", 100.0); // Blocked
        ps.processPayment("VIP", 5000.0); // VIP handling
    }
}

/*
 * Expected:
 *
 * Processing standard payment of $50.0 for Alice
 * Transaction blocked for Banned user
 * Instant VIP transfer for $5000.0
 */
