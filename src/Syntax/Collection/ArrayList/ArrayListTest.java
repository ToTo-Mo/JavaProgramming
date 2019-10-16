package Syntax.Collection.ArrayList;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(); 
        
        // 데이터 추가하기 
        list.add("aaa"); 
        list.add("bbb"); 
        list.add(2, "ccc"); 
        list.add("ddd"); 
        System.out.println("구성 데이터 : " + list); 
    
        // 데이터 위치 파악 
        int pos = list.indexOf("bbb"); 
        System.out.println("bbb의 위치 : " + pos); 

        // ArrayList가 비어 있는지 검사, 데이터 포함 여부 검사 
        boolean check1 = list.isEmpty(); 
        boolean check2 = list.contains("ddd");
        System.out.println("비어 있음 : " + check1 + "포함 여부 : " + check2); 

        // 데이터 갯수 구하기 
        int size = list.size(); 
        System.out.println("리스트의 크기 : " + size); 

        // 특정 위치 데이터 구하기 
        String item = list.get(0); 
        System.out.println("0번째 위치 데이터 : " + item); 

        // 데이터 반복 처리 - 첫번째 방법 
        System.out.println("데이터 반복 처리 - 첫번째 방법"); 
        for (int i = 0; i < list.size(); i++) { 
            System.out.println("Index: " + i + " - Item: " + list.get(i)); 
        } 
        
        // 데이터 반복 처리 - 두번째 방법 
        System.out.println("데이터 반복 처리 - 두번째 방법"); 
        for (String str : list) { 
            System.out.println("Item is: " + str); 
        } 

        // 데이터 반복 처리 - 세번째 방법 
        System.out.println("데이터 반복 처리 - 세번째 방법"); 
        for (Iterator<String> it = list.iterator(); it.hasNext();) { 
            System.out.println("데이터 : " + it.next()); 
        }

        System.out.println("데이터 반복 처리 - 네번쨰 방법");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println("데이터 : " +it.next());
        }

        // 데이터 수정 
        list.set(1, "eee"); 
        System.out.println("수정 후 리스트 : " + list); 

        // 지정 위치 데이터 제거 및 주어진 데이터가 저장되어 있는 첫 요소를 제거
        list.remove(0); 
        list.remove("ccc"); 
        System.out.println("리스트의 최종 내용 : " + list); 
        
        // ArrayList를 Array로 변환
        String[] simpleArray = list.toArray(new String[list.size()]); 
        System.out.println("변환 배열 : " + Arrays.toString(simpleArray));
    }
    
}