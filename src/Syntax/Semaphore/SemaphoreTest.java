package Syntax.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		final int numOfThreads = 100;
		final int numOfpermits = 20; //한번에 실행할 스레드 수
		Semaphore semaphore = new Semaphore(numOfpermits, true);
		ThreadB threads[] = new ThreadB[numOfThreads];
		for (int i=0; i < numOfThreads; i++) {
			threads[i] = new ThreadB(semaphore, "Tread " + i);
			threads[i].start();
		}
	}
}

class ThreadB extends Thread{
	String threadName;
	Semaphore semaphore;
	
	public ThreadB(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		threadName = name;
	}
	public void run(){
		try {
			semaphore.acquire();
			System.out.println(threadName + " 세마포 획득 ...");
			System.out.println(threadName + " 작업 중 ...");
			Thread.sleep(3000);
			System.out.println(threadName + " 작업 종료 ...");
			System.out.println(threadName + " 세마포 양도 ...");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
