privileged aspect QuattroSync extends Sync {

    pointcut build(Semaforo[] sem): execution(Incrocio.new(..)) && args(*, sem) && if(sem.length == 4);

    pointcut go(Incrocio inc): execution(* Incrocio.go()) && this(inc) && if(inc.semafori.length == 4);

    // in questo caso le policy di gestione di incroci a 3 e quattro vie sono uguali
    // ma nel caso generale potrebbero esistere incroci con policy speciali
    // quindi ognuno si gestisce il proprio onBuild e onGo a parte (in questo esempio
    // sono uguali)

    @Override
    void onBuild(Semaforo[] sem) {
        // System.out.println("SYNC 4");
        for (int i = 0; i < sem.length; i++) {
            sem[i].setColore(i % 2 == 0 ? Semaforo.Colore.Verde : Semaforo.Colore.Rosso);
        }
    }

    @Override
    void onGo(Semaforo[] sem) {
        // System.out.println("SYNC 4");
        boolean proceed = true;
        for (var s : sem) {
            if (s.getColore() == Semaforo.Colore.Verde) {
                proceed = false;
                break;
            }
        }

        for (var s : sem) {
            if (s.getColore() == Semaforo.Colore.Rosso && !proceed)
                continue;
            s.go();
        }
    }

}
