package Example;

public class Circle {

    private Point center;
    private int radius;

    public Circle(int x, int y, int r)
    {
        this.center = new Point(x,y);
        this.radius = r;
    }

    public Circle(Point p, int r)
    {
        this(p.getX(),p.getY(),r);
    }
    public Circle()
    {
        this(new Point(0,0),0);
    }

    public Circle(int r)
    {
        this(0,0,r);
    }


    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [center=" + center + ", radius=" + radius + "]";
    }

    public static void program()
    {
        Point p = new Point(5,3);

        Circle c1 = new Circle() ,c2 = new Circle(3) ,c3 = new Circle(p,4),c4 = new Circle(9,7,5);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
    }
}

class Point {
    private int x, y;

    public Point() {
        this(0,0);
    }

    public Point(int value_x, int value_y) {
        x = value_x;
        y = value_y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}