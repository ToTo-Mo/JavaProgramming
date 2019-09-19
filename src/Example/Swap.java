package Example;

public class Swap {
	public static void swap(Integer a, Integer b)
	{
		int temp = a.value();
		a.value(b.value());
		b.value(temp);
	}
	
	public void Program()
	{
		Integer a = new Integer(3);
		Integer b = new Integer(5);
		
		
		Swap.swap(a,b);
		
		System.out.println(a.value());
		System.out.println(b.value());
	}

}

class Integer
{
	private int x;
	
	public Integer(int value)
	{
		x = value;
	}
	
	int value() {return x;}
	void value(int value) {x = value;}

	public static int parseInt(String nextLine) {
		return 0;
	}
}