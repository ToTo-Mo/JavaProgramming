package Syntax.Array;

public class Copy{

    public static void main(String[] args){
        
        //배열 값 복사
        int[] varr1 = {1,2,3};
        int[] varr2 = varr1.clone();

        //레퍼런스 복사
        int[] rarr1 = {4,5,6};
        int[] rarr2 = rarr1;

        System.out.println("값 복사");
        varr2[0] = 0;
        System.out.println("varr1[0] : "+varr1[0] + "   주소 : ");
        System.out.println("varr2[0] : "+varr2[0]);

        System.out.println("레퍼런스 복사");
        rarr1[0] = 7;
        System.out.println("rarr1[0] : "+rarr1[0]);
        System.out.println("rarr2[0] : "+rarr2[0]);
    
    }


}