package Syntax.Interface;

public interface IShape{
    public double area();
    public double volume();
    public String getName();
}

class Rectangle implements IShape{

    public double area() {
        return 23.2;
    }

    public double volume() {
        return 10.0;
    }

    public String getName() {
        return "rectangle";
    }

}