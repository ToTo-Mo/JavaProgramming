package Syntax.Thread;

public class Yield extends Thread {
	public static void main(String[] args) {
		Thread producer = new Producer();
		Thread consumer = new Consumer();
	 
		producer.setPriority(Thread.MIN_PRIORITY); 
		consumer.setPriority(Thread.MAX_PRIORITY); 
	 
		producer.start();
		consumer.start();
	}
}


class Producer extends Thread{
	public void run(){
		for (int i = 0; i < 200; i++){
			System.out.println("Producer : Produced Item " + i);
			Thread.yield();
		}
	}
}
class Consumer extends Thread{
	public void run(){
		for (int i = 0; i < 200; i++){
			System.out.println("Consumer : Consumed Item " + i);
			Thread.yield();
		}
	}
}
