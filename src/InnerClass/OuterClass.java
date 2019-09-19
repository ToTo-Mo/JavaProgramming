package InnerClass;

public class OuterClass {
	
	private int num = 10;
	
	private class InnerClass
	{
		private int x = 5;

		public void Print()
		{
			System.out.println("this is an inner class : " + num);
		}
	}

	void Display_inner()
	{
		InnerClass inner1 = new InnerClass();
		inner1.Print();

		InnerClass inner2 = new InnerClass();
		System.out.println(inner2.x);

		class InnerClass2
		{
			int y = 5;

			public void Print()
			{
				System.out.println("This is an inner2 class : " + y);

			}
		}

		InnerClass2 inner3 = new InnerClass2();
		inner3.Print();
	}
}

class Program
{
	void program()
	{

	}
}
