package Syntax.Thread.ExplicitLock.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadA {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        ThreadB newThread1 = new ThreadB(lock, map);
        ThreadB newThread2 = new ThreadB(lock, map);

        newThread1.start();
        newThread2.start();
        
        lock.writeLock().lock();
        System.out.println("쓰기용 락 획득 ...");
        try {
            map.put("이름", "병만");
        } finally {
            System.out.println("쓰기용 락 양도 ...");
            lock.writeLock().unlock();
        }
    }
}

class ThreadB extends Thread{
	ReadWriteLock lock;
	Map<String, String> map;
	public ThreadB(ReadWriteLock lock, Map<String, String> map) {
		this.lock = lock;
		this.map = map;
	}
	public void run(){
		lock.readLock().lock();
		System.out.println("읽기용 락 획득 ...");
		try {
			System.out.println(map.get("이름"));
			sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		 } finally {
			System.out.println("읽기용 락 양도 ...");
			lock.readLock().unlock();
		}
	}
}
