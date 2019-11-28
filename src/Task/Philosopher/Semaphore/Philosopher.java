/*
    철학자
        status 생각하다, 밥먹다, 배가 고프다

        밥을 먹을때는 양손에 포크를 들어야하며
        총 5명의 사람과 5개의 포크가 있다

        즉 세마포어로 2개의 스레드만 작동하도록

*/

package Task.Philosopher.Semaphore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    private String name;
    private int number;

    public static final Semaphore semaphore = new Semaphore(2);

    public Philosopher(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void think() {
        System.out.println(name + " thinking ...");
    }

    public void eat() {
        System.out.println(name + " eating ... yum-yum-yum");
    }

    public void takeFork(int i) {
        System.out.println(name + " attemp to take (" + i + ") fork ...");
        Fork fork = Tableware.forks.get(i);
        fork.useFork();
        System.out.println(name + " take (" + i + ") fork now!");
    }

    public void putFork(int i) {
        System.out.println(name + " put (" + i + ") fork down ...");
        Fork fork = Tableware.forks.get(i);
        fork.unUseFork();
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (true) {
            think();
            try {
                semaphore.acquire();

                takeFork(this.number);
                takeFork((this.number + 1) % 5);
                eat();
                putFork(this.number);
                putFork((this.number + 1) % 5);        
                
                semaphore.release();

                long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
                System.out.println( "경과 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력

            } catch (Exception e) {
                System.out.println("Exception occured!!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("컴퓨터소프트웨어공학과 20161213 최범휘");
        System.out.println("뮤텍스와 세마포어를 이용한 식사하는 철학자 문제");
        Thread.sleep(2000);
        Philosopher a = new Philosopher("A", 0);
        Philosopher b = new Philosopher("B", 1);
        Philosopher c = new Philosopher("C", 2);
        Philosopher d = new Philosopher("D", 3);
        Philosopher e = new Philosopher("E", 4);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(a);
        exec.execute(b);
        exec.execute(c);
        exec.execute(d);
        exec.execute(e);
    }
}

class Fork {
    Lock lock = new ReentrantLock();

    public void useFork() {
        lock.lock();
    }

    public void unUseFork() {
        lock.unlock();
    }
}

class Tableware {
    public static final List<Fork> forks = new ArrayList<Fork>(
        Arrays.asList(new Fork(),new Fork(),new Fork(),new Fork(),new Fork()));
}