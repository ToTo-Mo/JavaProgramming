package Syntax.Array;

public class MultiDimension{

    public static void print(String sentence,int[][] array){
        System.out.print(sentence);

        for(int[] arr : array){
            for(int elem : arr){
                System.out.print(elem + " ");
           }
        }

        System.out.println();
    }

    public static void main(String[] args){

        int[][] arr2d = {{1,2,3},{4,5,6}};

        int[][] arr2d_copy = arr2d.clone(); //arr2d.clone(); 과 동일 의미

        int[][] arr2d2 = {{7,8,9},{10,11,12}};
        int[][] arr2d2_copy = arr2d2;

        //for을 사용하면 값이 복사됨
        System.out.println("for문을 사용한 복사");
        forCopy(arr2d, arr2d_copy);
        print("arr2d : ",arr2d);
        arr2d[0][0] = 10;
        print("arr2d copy : ",arr2d_copy);
        print("arr2d : ",arr2d);

        //foreach를 이용하면 레퍼런스가 복사됨
        System.out.println("\nforeach문을 사용한 복사");
        foreachCopy(arr2d, arr2d_copy);
        print("arr2d : ",arr2d);
        arr2d[0][0] = 1;
        print("arr2d copy : ",arr2d_copy);
        print("arr2d : ",arr2d);
       
    }

    private static void forCopy(int[][] arr2d, int[][] arr2d_copy) {
        for(int i =0 ; i<arr2d_copy.length; i++){
            arr2d_copy[i] = arr2d[i].clone();
        }
    }

    private static void foreachCopy(int[][] arr2d, int[][] arr2d_copy) {
        int index = 0;
        for(int[] arr : arr2d_copy){
            arr = arr2d[index++].clone();
        }
    }
}