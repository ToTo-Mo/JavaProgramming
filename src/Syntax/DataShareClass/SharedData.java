package Syntax.DataShareClass;

public class SharedData
{
    final int sharedConstant = 100;
    private int sharedValue;

    public SharedData(int sharedValue) {
        this.sharedValue = sharedValue;
        
    }
    public SharedData()
    {
        
    }

    public int getSharedConstant() {
        return sharedConstant;
    }

    public int getSharedValue() {
        return sharedValue;
    }

    public void setSharedValue(int sharedValue) {
        this.sharedValue = sharedValue;
    }

    public static void program()
    {
        SharedData buffer = new SharedData();

        A a = new A(buffer);
        B b = new B(buffer);

        for (int i =0; i<3; i++)
        {
            a.updateData();
            b.readData();
        }
    }

}

class A
{
    SharedData sharedData;

    public A(SharedData sharedData)
    {
        this.sharedData = sharedData;
    }

    public void updateData()
    {
        System.out.println("상수 : " + sharedData.sharedConstant);
        sharedData.setSharedValue(5);
    }
}

class B
{
    SharedData sharedData;

    public B(SharedData sharedData)
    {
        this.sharedData = sharedData;
    }

    public void readData()
    {
        System.out.println("상수 : " + sharedData.sharedConstant);
        System.out.println(sharedData.getSharedValue());
    }
}