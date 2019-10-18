package Syntax.Collection.List.Queue;

import java.util.*;

public class QueueTest{
    public static void main(String[] args) {
        Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(5);    //우선 순위 큐
        Random rand = new Random();

        for(int i=0;i<5;i++)
            integerPriorityQueue.add(rand.nextInt(100));
        
        for(int i=0;i<5;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }

        Queue<String> stringPriorityQueue = new PriorityQueue<String>(3);

        stringPriorityQueue.add("def");
        stringPriorityQueue.add("abc");
        stringPriorityQueue.add("fff");

        for(int i=0;i<3;i++){
            String in = stringPriorityQueue.poll();
            System.out.println("Processing String:"+in);
        } 
    }
    
}