package Example;

import java.util.Scanner;

public class test
{
    private int id;
    private String name;
    private int price;
    
    public void input()
    {
        Scanner scanner = new Scanner(System.in);
        this.id = Integer.parseInt(scanner.nextLine());

        // this.id = ioHandler.inputInteger("��ǰ�� �Ϸ� ��ȣ : ");
        // this.name = ioHandler.inputString("��ǰ�� �̸� : ");
        // this.price = ioHandler.inputInteger("��ǰ�� ���� : ");
    }

    public void print()
    {
        System.out.println("��ǰ ��ȣ : "+this.id);
        System.out.println("��ǰ�� �̸� : "+this.name);
        System.out.println("��ǰ ���� : "+this.price);
    }

    public boolean isCheaper(test other)
    {
        return this.price > other.price ? true : false;
    }

    public static void program()
    {
    	test p1 = new test();
        test p2 = new test();
        
        p1.input();
        p2.input();

        if( p1.isCheaper(p2))
        {
            p1.print();
            System.out.println(p1.name + "�� �� �����մϴ�.");
        }
        else
        {
            p2.print();
            System.out.println(p2.name + "�� �� �����մϴ�.");
        }
    }
}

class ioHandler
{
    public static int inputInteger(String sentence)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(sentence);
        // return Integer.parseInt(new Scanner(System.in).nextLine());
        int a =Integer.parseInt(input.nextLine()); 
        return a;
    }

    public static String inputString(String sentence)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(sentence);
        return input.nextLine();
    }
}