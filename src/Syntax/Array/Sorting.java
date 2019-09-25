package Syntax.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        arraySort();
        instanceSort();
    }

    private static void sortProblem(){
        int val,cnt = 0, sum = 0;
        int[] array = new int[100];

        Scanner input = new Scanner(System.in);
        System.out.println("0과 100사이의 값을 입력(그이외 종료) : ");
        val = input.nextInt();
        while(val >=0 && val <= 100){
            array[cnt] = val;
            cnt = cnt + 1;
            System.out.println("0과 100사이의 값을 입력(그이외 종료) : ");
            val = input.nextInt();
        }

        
    }
    
    private static void arraySort() {
        int[] array = { 1, 5, 2, 3, 1, 2, 3 };

        //정렬 전 배열 원소
        for (int elem : array)
            System.out.print(elem + " ");

        System.out.println();
        Arrays.sort(array); //정렬  내림차순은 없음

        //정렬 후 배열 원소
        for (int elem : array)
            System.out.print(elem + " ");

        System.out.println();
    }

    private static void instanceSort(){
        String[] str = {"hi","my","name","is","beomhwi"};

         //정렬 전 객체 원소
        for(String elem : str)
            System.out.print(elem +  " ");

        System.out.println();
        Arrays.sort(str);
            
        //정렬 후 객체 원소
        for(String elem : str)
            System.out.print(elem +  " ");

        System.out.println();
    }


}