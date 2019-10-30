package Syntax.Scanner;

import java.io.*;
import java.util.Scanner;

public class FileRead{
    public static void main(String[] args) throws Exception{
        File file = new File("src/Syntax/Scanner/scores.txt");
        Scanner input = new Scanner(file);
        
        while(input.hasNextLine()){
            String[] info = input.nextLine().split(":");

            double sum = 0;
            for(int i=1; i<info.length; i++)
                sum += Integer.parseInt(info[i]);
            
            System.out.println(String.format("평균 : %f",sum/(info.length-1)));
        }

        input.close();
    }
}