public aspect WormholeLogger {

    pointcut log(Object th, Object ta, int a):
        call(* Account.*(..)) && target(ta) && this(th) && args(a);

    before(Object th, Object ta, int a): log(th, ta, a) {
        System.out.println(th);
        System.out.println(ta);
        System.out.println(a);
    }

}
