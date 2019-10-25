package Syntax.Collection.List.LinkedList;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
		LinkedList <String> stack = new LinkedList<String>(); 
		stack.push("aaa");  //add last index
		stack.push("bbb");
		System.out.println("Stack : " + stack);
		String s = stack.pop(); //delete last index
		System.out.println(s + "가(이) 팝업됨");
		System.out.println("Stack : " + stack);
		
		LinkedList <String> queue = new LinkedList<String>(); 
		queue.offer("ccc"); //add last index
		queue.offer("ddd");
		System.out.println("Queue : " + queue);
		String ss = queue.poll();   // delete first index
		System.out.println(ss + "가(이) 반환 및 제거됨");
        System.out.println("Queue : " + queue);
        
        LinkedList <String> list = new LinkedList<String>(); 
		list.add("eee");
		list.add("fff");
		list.add(0, "ggg");
		System.out.println("List : " + list);
		String sss = list.remove(1);
		System.out.println(sss + "가(이) 제거됨");
		String t = list.get(1);
		System.out.println("인덱스 1 위치의 값은 " + t);
		System.out.println("List : " + list);
    }
}