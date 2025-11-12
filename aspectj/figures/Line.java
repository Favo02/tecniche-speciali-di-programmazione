public class Line implements FigureElement {

    private Point p1, p2;

    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void moveBy(int dx, int dy) {
        p1.moveBy(dx, dy);
        p2.moveBy(dx, dy);
    }

    @Override
    public String toString() {
        return "Line [p1=" + p1 + ", p2=" + p2 + "]";
    }

}
