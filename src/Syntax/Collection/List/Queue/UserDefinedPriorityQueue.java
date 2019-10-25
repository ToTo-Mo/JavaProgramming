package Syntax.Collection.List.Queue;

import java.util.*;

public class UserDefinedPriorityQueue {

    public static void main(String[] args){
        final Comparator<Cat> idComparator = new Comparator<Cat>() {
            public int compare(Cat c1, Cat c2) {
                // 내림차순
                return c2.size - c1.size;
            }
        };

        Random rand = new Random();
        // Comparator 객체를 생성하여 우선 순위 큐의 요소들을 비교
        Queue<Cat> catPriorityQueue = new PriorityQueue<Cat>(3, idComparator);
        catPriorityQueue.add(new Cat(5));
        catPriorityQueue.add(new Cat(3));
        catPriorityQueue.add(new Cat(7));
        for(int i=0;i<3;i++){
            Cat in = catPriorityQueue.poll();
            System.out.println("Processing Cat:"+in.size);
        }

        Queue<CompareCat> CompareCatPriorityQueue = new PriorityQueue<CompareCat>(3);
        
        for(int i=0; i<10; i++)
            CompareCatPriorityQueue.add(new CompareCat(10));
        

        for(int i=0; i<CompareCatPriorityQueue.size();i++){
            CompareCat in = CompareCatPriorityQueue.poll();
            System.out.println("Processing Cat:"+in.size);
        }
    }
}
class Cat{
    int size;

    public Cat(int size) {
        this.size = size;
    }
}

class CompareCat implements Comparable{
    int size;

    public CompareCat(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object obj) {
        // TODO Auto-generated method stub
        // 오름차순
        return this.size - ((CompareCat)obj).size;
    }
}