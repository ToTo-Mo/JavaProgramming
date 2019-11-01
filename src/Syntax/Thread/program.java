package Syntax.Thread;

public class program {
	public static void main(String[] args) {
		Thread t = Thread.currentThread(); // 현 쓰레드 파악
		t.setName("Test Thread");
		t.setPriority(1);  // 우선순위 1로 지정 (1~10 가능, 기본 5)
		int p = t.getPriority(); // 우선순위 파악
		System.out.println(t.getName() + " : " + p);
	}
}
