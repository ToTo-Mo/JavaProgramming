package Example;

public class TypeCasting{
    public static void main(String[] args){
        A temp = new B();
        temp.print();

        System.out.println("부모 : "+temp.x);


        //허용 안됨
        B temp2 = (B) new A();
        temp2.print();
        System.out.println("자식 : "+temp.x);
    }
}

class A{
    public int x = 53;
    public void print(){
        System.out.println("부모 : "+x);
    }
}

class B extends A{
    public int x = 17;
    public String y = "abc";
    public void print(){
        System.out.println("자식: "+x+", "+y);
    }
}