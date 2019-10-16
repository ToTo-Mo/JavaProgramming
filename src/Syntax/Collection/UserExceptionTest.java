package Syntax.Collection;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class UserExceptionTest {
	public static void main(String[] args) {
        //가변 배열인 Vector 선언
        Vector<Double> v = new Vector<Double>();
        
        int count = 10;
        while(count != 0){
            v.add(new Random().nextDouble());
            count--;
        }
        // 반복적인 작업을 수행 할 수 있도록 하는 Iterator
		Iterator<Double> it = v.iterator();
        
        // Iterator에 정의된 hasNext()로 다음 요소가 있는지 판단
		double sum = 0.0, d;
		while (it.hasNext()) {
            d = it.next();
            System.out.println(d);
			sum += d;
		}
		System.out.println(sum);
	}
}