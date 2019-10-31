package Syntax.Scanner;

import java.io.*;
import java.util.Scanner;

public class Program{
    public static final String FILENAME = "src/Syntax/Scanner/text.txt";
    public static void main(String[] args){
        try{
            File file = new File(FILENAME);
            Scanner fileWriter = new Scanner(System.in);
            
            // nextInt()를 입력후에는 숫자와 개행문자가 같이 버퍼에 있으므로
            // 다음 nextLine()에서는 문자열을 입력받지 않고 끝나버린다.
            int i = fileWriter.nextInt();
            String s = fileWriter.nextLine();
            System.out.println(i + " " + s);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}