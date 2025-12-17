public class Main {
    public static void main(String[] args) {
        ATM _atm1 = new ATM(001);
        ATM _atm2 = new ATM(002);
        ATM _atm3 = new ATM(003);

        _atm1.deposit("Walter", 2500);
        _atm2.withdraw("Cazzola", 1000);
        _atm3.deposit("Cazzola", 7000);
        _atm3.deposit("Walter Cazzola", 1500);
        _atm1.withdraw("Walter", 500);
        _atm2.withdraw("Walter Cazzola", 1500);
        _atm2.deposit("Walter", 7000);
        _atm1.deposit("Walter Cazzola", 3500);

        System.out.println("Walter :- " + _atm1.balance("Walter"));
        System.out.println("Cazzola :- " + _atm1.balance("Cazzola"));
        System.out.println("Walter Cazzola :- " + _atm1.balance("Walter Cazzola"));
    }
}

/*
 * EXPECTED
 *
 * ATM 1:
 * CC(Walter) :- 0
 * 2500
 *** deposit()
 *
 * ATM 2:
 * CC(Cazzola) :- 0
 * 1000
 *** withdraw()
 *
 * ATM 3:
 * CC(Cazzola) :- -1000
 * 7000
 *** deposit()
 *
 * ATM 3:
 * CC(Walter Cazzola) :- 0
 * 1500
 *** deposit()
 *
 * ATM 1:
 * CC(Walter) :- 2500
 * 500
 *** withdraw()
 *
 * ATM 2:
 * CC(Walter Cazzola) :- 1500
 * 1500
 *** withdraw()
 * z *
 * ATM 2:
 * CC(Walter) :- 2000
 * 7000
 *** deposit()
 * ATM 1:
 * CC(Walter Cazzola) :- 0
 * 3500
 *** deposit()
 *** balance()
 * Walter :- 9000
 *** balance()
 * Cazzola :- 6000
 *** balance()
 * Walter Cazzola :- 3500
 */
