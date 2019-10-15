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

        int result_size = fact(in_num) / fact(in_num - elem_num);
        String[] result = new String[result_size];

        result[0] = elem_st;
        result[9] = elem_end;

        for(int i=1; i<result_size-1; i++)
        {   

        }

    }

    public static int fact(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}