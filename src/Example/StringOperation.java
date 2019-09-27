package Example;

import java.util.Scanner;

public class StringOperation {

    public static void main(String[] args){
        StringOperation.example2();
    }

    public static void example1(){
        String delimeter = " ";
        String words = "0";
        String[] split = null;
        Scanner input = new Scanner(System.in);

        while(!words.equals("-1")){
            words = input.nextLine();
            split = words.split(delimeter);
            int result = 0;

            if(split[1].equals("+"))
            result = Integer.parseInt(split[0]) + Integer.parseInt(split[2]);

            if(split[1].equals("-"))
                result = Integer.parseInt(split[0]) - Integer.parseInt(split[2]);

            if(split[1].equals("/"))
                result = Integer.parseInt(split[0]) / Integer.parseInt(split[2]);

            if(split[1].equals("*"))
                result = Integer.parseInt(split[0]) * Integer.parseInt(split[2]);
        

            System.out.println("결과 : "+result);
        }
    }

    public static void example2(){
        String delimeter = " ";
        String words = "0";
        String[] split = null;
        Scanner input = new Scanner(System.in);

        while(!words.equals("-1")){
            words = input.nextLine();
            split = words.split(delimeter);
            int result = Integer.parseInt(split[0]);

            for(int i=1; i<split.length-1; i++){
                if(split[i].equals("+"))
                result += Integer.parseInt(split[i+1]);    
            }

            System.out.println("결과 : "+ result);
        }
    }
}