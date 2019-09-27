package Syntax.String;

public class Builder{
    public static void main(String[] args){
        StringBuilder str1 = new StringBuilder("가");
        StringBuilder str2 = new StringBuilder("a");
        StringBuilder str3 = new StringBuilder("1");
        StringBuilder str4 = new StringBuilder("&");

        System.out.println("길이 : " + str1.length());
        str1.append("01234567890123456789");
        System.out.println("길이 : " + str1.capacity());
        System.out.println("길이 : " + str2.length());
        System.out.println("길이 : " + str3.length());
        System.out.println("길이 : " + str4.length());

    }
}