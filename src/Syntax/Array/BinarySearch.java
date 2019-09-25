package Syntax.Array;

import java.util.Arrays;

public class BinarySearch
{
    public static void main(String[] args){
        int[] array = {5,1,2,7,8,5,2};
        Arrays.sort(array);

        int i = Arrays.binarySearch(array, 3);
        System.out.println(i);
    }
}