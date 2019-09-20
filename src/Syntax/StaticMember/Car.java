package Syntax.StaticMember;

public class Car
{
    private static int MAX_SPEED = 300;
    private String name;

    public static int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}