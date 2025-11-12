public abstract class Caller {
    private Caller next;

    public void setNext(Caller next) {
        this.next = next;
    }

    public void call() {
        next.call();
    }
}
