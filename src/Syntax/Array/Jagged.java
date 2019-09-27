package Syntax.Array;

public class Jagged{

    public static void main(String[] args){

        int[][] array = new int[4][];

        array[0] = new int[]{2,3,4,5};
        array[1] = new int[]{3,4,5,6,7};
        array[2] = new int[]{8,9};
        array[3] = new int[]{10};

        for(int[] row : array){
            for(int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}