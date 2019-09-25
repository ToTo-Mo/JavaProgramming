package Syntax.Array;

public class ArrayParameter
{

    public ArrayParameter() {

    }

    public static void main()
    {
        //배열을 이외에는 call-by-value임

        int x = 10, y = 20;
        swap(x,y);  // call-by-value 이므로 swap이 안됨
    }
    
    public static void swap(int x, int y)
    {
        int temp = x;
        x = y;
        y = temp;
    }
}