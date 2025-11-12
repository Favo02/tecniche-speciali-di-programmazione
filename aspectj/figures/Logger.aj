public aspect Logger {

    pointcut move(int x, int y):
        call(void FigureElement.moveBy(int, int)) && args(x, y);

    after(int x, int y) returning: move(x, y) {
        System.out.println(String.format("%s, %d %d", thisJoinPoint.toString(), x, y));
    }

}
