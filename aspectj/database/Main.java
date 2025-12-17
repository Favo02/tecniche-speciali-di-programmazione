public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting System ---");
        new SystemBoot().startUp();

        System.out.println("\n--- User Request ---");
        new UserRequest().handle();
    }
}

/*
 * expected:
 *
 * --- Starting System ---
 * >> [BOOT SEQUENCE] Initiating DB connection...
 * Database connecting...
 *
 * --- User Request ---
 * Database connecting...
 */
