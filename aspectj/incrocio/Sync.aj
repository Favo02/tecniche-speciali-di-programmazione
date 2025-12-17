privileged abstract aspect Sync {

    // ogni policy cattura solo gli incroci che vuole
    abstract pointcut build(Semaforo[] sem);

    // ogni policy cattura solo gli incroci che vuole
    abstract pointcut go(Incrocio inc);

    after(Semaforo[] sem): build(sem) {
        onBuild(sem);
    }

    void around(Incrocio inc): go(inc) {
        onGo(inc.semafori);
        // no proceed
    }

    // policy di costruzione
    abstract void onBuild(Semaforo[] sem);

    // policy di avanzamento
    abstract void onGo(Semaforo[] sem);

}
