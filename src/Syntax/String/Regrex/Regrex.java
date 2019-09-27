package Syntax.String.Regrex;

import java.util.Scanner;

public class Regrex{

    public static void main(String[] args){
        String regrex = "01[0-9]-\\d{4}-\\d{4}";
        String example;
        Scanner input = new Scanner(System.in);

        while(true){
            example = input.nextLine();
            System.out.println("등록된 전화번호 : " + example.matches(regrex));    
        }
        
    }
}