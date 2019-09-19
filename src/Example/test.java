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

        // this.id = ioHandler.inputInteger("상품의 일련 번호 : ");
        // this.name = ioHandler.inputString("상품의 이름 : ");
        // this.price = ioHandler.inputInteger("상품의 가격 : ");
    }

    public void print()
    {
        System.out.println("상품 번호 : "+this.id);
        System.out.println("상품의 이름 : "+this.name);
        System.out.println("상품 가격 : "+this.price);
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
            System.out.println(p1.name + "가 더 저렴합니다.");
        }
        else
        {
            p2.print();
            System.out.println(p2.name + "가 더 저렴합니다.");
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