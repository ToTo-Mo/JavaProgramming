package problem;

import java.util.Scanner;

public class g{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String temp = input.nextLine();
        int in_num = Integer.parseInt(temp.split(" ")[0]), elem_num = Integer.parseInt(temp.split(" ")[1]);
        
        temp = input.nextLine();
        String[] elem = temp.split("");

        temp = input.nextLine();
        String elem_st = temp.split(" ")[0], elem_end = temp.split(" ")[1];
 
        {   

        }

    }

    public static long fact(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}