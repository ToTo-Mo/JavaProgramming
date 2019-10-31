package Syntax.Scanner;

import java.io.*;
import java.util.Scanner;

public class Application{
    public static void main(String[] args) throws Exception{
        File file = new File("src/Syntax/Scanner/expression.txt");
        Scanner input = new Scanner(file);
        //정규식을 통한 구분
        //input.useDelimiter("\\s*\\t\\s*");

        while(input.hasNextLine()){
            //split을 이용한 문자열 분리 방법
            // String[] info = input.nextLine().replace(" ","").split("\\+");
            // 또는
            String[] info = input.nextLine().split("\\s*[+*/-]\\s*");
            double sum = 0;
            for(int i=0; i<info.length; i++)
                sum += Integer.parseInt(info[i]);
            
            System.out.println("합 : " + sum);
        }

        input.close();
    }
}