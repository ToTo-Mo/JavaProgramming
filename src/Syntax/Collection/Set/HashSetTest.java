package Syntax.Collection.Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
		HashSet<Cat> cset = new HashSet<Cat>();
		Cat c = new Cat(2);
		cset.add(c);
		cset.add(new Cat(1));
		cset.add(new Cat(3));
		cset.add(new Cat(5));
		cset.add(new Cat(4));
		// 이미 cset에 존재하므로 추가가 안됨
		cset.add(c);
		// 기존에 new Cat(5)와는 다른 객체 이므로 추가됨
		// 그럼 어떻게 해야 같은 객체로 취급 할까? Cat 클래스의 equals를 통해
		// 동일한 Cat 객체인지 확인
		cset.add(new Cat(5));

		Iterator<Cat> iterator = cset.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
	}

}

class Cat implements Comparable{
    int size;

    public Cat(int size) {
        this.size = size;
	}
	
	@Override
	public int hashCode(){
		return Integer.toString(size).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Cat cat = (Cat) obj;
		// TODO Auto-generated method stub
		return (this.size == cat.size);
	}

    @Override
    public String toString() {
        return "Cat [size=" + size + "]";
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return size - ((Cat)o).size;
	}
}
