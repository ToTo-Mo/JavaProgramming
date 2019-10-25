package Syntax.AnonymousClass;

interface Anonymous_I{
    public void display();
}

public class Anonymous{

    public void display(Anonymous_I ai){
        ai.display();
    }

    public static void main(String[] args){

        //인터페이스 선언과 동시에 정의
        Anonymous_I A = new Anonymous_I(){
            public void display() {
                System.out.println("helloworld");
            }
        };

        A.display();

        Anonymous anonymous = new Anonymous();

        anonymous.display(new Anonymous_I(){
            public void display(){
                System.out.println("이런것도 되지");
            }
        });
    }
}