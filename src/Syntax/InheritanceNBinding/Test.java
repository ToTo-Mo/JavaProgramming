package Syntax.InheritanceNBinding;

public class Test{

    
    public static void main(String[] args){
        A c1 = new B();
        A c2 = new A();
        
        System.out.print("c1 : ");
        System.out.println(c1.X);
        c1.f();
        
        c2.display();

        System.out.print("c1 : ");
        System.out.println(A.Y);
        A.y();

        System.out.print("c2 : ");
        System.out.println(B.Y);
        B.y();
    }
}

class A{
    public int X = 2;
    public void f() {System.out.println("A");}
    
    public static int Y = 3;
    public static void y(){System.out.println("Ay");}

    public void display(){
        System.out.println(X);
        f();
    }
}

class B extends A{
    public int X = 5;
    public void f() {System.out.println("B");}

    
    public static int Y = 6;
    public static void y(){System.out.println("By");}
}
