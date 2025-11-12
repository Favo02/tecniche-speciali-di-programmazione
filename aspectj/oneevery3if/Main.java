/* ESERCIZIO INVENTATO:
 * per ogni if, si entra in quell'if solo alla terza volta
 * che la condizione è vera (ovvero, si entra nell'if 1/3 delle volte
 * che ci si entrerebbe normalmente)
 */

public class Main {
    public static void main(String[] args) {

        Cane pluto = new Cane("Pluto");
        Cane gio = new Cane("Gio");
        pluto.bau(true);
        pluto.bau(true);
        pluto.miao(false);
        pluto.miao(true);
        gio.bau(false);
        gio.bau(true);
        gio.bau(true);
        pluto.miao(true);
        gio.bau(true);

    }
}
