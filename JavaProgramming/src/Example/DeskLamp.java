package Example;

public class DeskLamp
{
    private boolean isOn;

    public void turnOn()
    {
        isOn = true;
    }

    public void turnOff()
    {
        isOn = false;
    }

    public void print()
    {
        System.out.println("램프가 " + (isOn == true ? "켜짐" : "꺼짐"));
    }

    public static void program()
    {
        DeskLamp lamp = new DeskLamp();

        lamp.turnOn();
        lamp.print();
        lamp.turnOff();
        lamp.print();
    }

}