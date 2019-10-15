package Syntax.Interface;

public class TypeCasting {
	public static void main(String[] args) { 
		IA p = new A();
		p.print();	
		//System.out.println("x : " + p.x); // 접근 불가능 	
	}
}
interface IA {
	public void print();
}
class A implements IA {
	public int x = 17;
	public String y = "abc";
	public void print(){
		System.out.println("print method :" + x);
		System.out.println("print method :" + y);
	}
}
