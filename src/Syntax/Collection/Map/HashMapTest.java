package Syntax.Collection.Map;

import java.util.HashMap;
import java.util.Random;

public class HashMapTest{
    public static void main(String[] args){
        HashMap map = new HashMap();
        int count = 0;

        for(int i=0; i<5; i++){
            map.put(new Cat(new Random().nextInt()),Integer.toString(count++));
        }

        for(Object i : map.keySet()){
            System.out.println(map.get(i));
        }

    }
}

class Cat implements Comparable {
	int size;
	public Cat(int s) {	size = s;	}
	public String toString() {  return size + "";  }
	public int hashCode() {  return size % 100;  }
	
	public boolean equals(Object ob) {
		Cat other = (Cat) ob;
		return other.size == this.size ? true:false;
	}
	@Override
	public int compareTo(Object o) {
		return size - ((Cat) o).size;
	}
}