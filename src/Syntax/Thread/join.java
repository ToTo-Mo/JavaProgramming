package Syntax.Thread;

import java.util.Scanner;

public class join {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("주 스레드 시작합니다.");
		Thread t = new Thread(new MyThread());
		t.start();
		System.out.println("자식 스레드 시작합니다.");
		
		System.out.println("주 스레드 기다립니다.");
		t.join();
		System.out.print("주 스레드 다시 시작합니다.");

    }
}

class MyThread implements Runnable {

    public void run() {
		System.out.println("정수 입력을 기다리고 있습니다. 입력 바랍니다. >> ");
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		System.out.println("자식 스레드 종료합니다");
	}

}