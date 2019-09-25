package Task;

import java.util.Random;

public class ArrayOperation{
    public static final int row = 3,column = 4;

    public static void main(String[] args){
        int[][] A = new int[row][column];
        int[][] B = new int[row][column];

        init_random(A);
        init_random(B);

        print("배열 A",A);
        print("배열 B",B);

        int[][] C = add(A,B);

        print("결과",C);

    }

    public static int[][] add(int[][] A,int[][] B)
    {
        int[][] C = new int[A.length][A[0].length];

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[i].length; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }
    public static void print(String sentence,int[][] array)
    {
        System.out.println(sentence);

        for(int[] arr : array){
            for(int elem : arr){
                System.out.print(elem+ " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void init_random(int[][] array){
        Random random = new Random();

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                array[i][j] = random.nextInt(100);
            }
        }
    }
}