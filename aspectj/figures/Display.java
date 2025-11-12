public class Display {

    public static void main(String[] args) {
        FigureElement point = new Point(5, 4);
        FigureElement line = new Line(5, 4, 6, 9);

        point.moveBy(1, 2);
        line.moveBy(2, 1);

        System.out.println(point);
        System.out.println(line);
    }

}
