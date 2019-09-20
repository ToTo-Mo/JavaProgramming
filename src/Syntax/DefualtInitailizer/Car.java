package Syntax.DefualtInitailizer;

public class Car {
    private int speed;
    private int gear;
    private String color;

    public Car(int s, int g, String c)
    {
        speed = s;
        gear = g;
        color = c;
    }
    public Car()
    {
        this(0,0,"red");
    }



    public void PrintInfo()
    {
        System.out.println("속도 : " + speed);
        System.out.println("기어 : " + gear);
        System.out.println("색상 : " + color);

    }

    public static void program()
    {
        Car c1 = new Car(0,1,"red"), c2 = new Car(20,3,"blue"),c3 = new Car();
        c1.PrintInfo();
        c2.PrintInfo();
        c3.PrintInfo();
    }
}

