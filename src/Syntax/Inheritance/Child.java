package Syntax.Inheritance;

public class Child extends Parent{

    int money;
    int grade;
    Child(int m, int g){
        money = m; grade = g;
        System.out.println("자식 생성자 호출");
    }
    Child(){
        this(0,0);
        System.out.println("자식 생성자 호출");
    }

    public static void main(String[] args){
        Child c1 = new Child();
        c1.name = "홍길동";
        System.out.println(c1.name);
    }
}