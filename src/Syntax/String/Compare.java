package Syntax.String;

public class Compare{
    public static void main(String[] args){
        String str1 = new String("hello world");
        String str2 = str1;
        String str3 = new String("hello world");


        //String 내용 자체가 같은지 판단
        boolean retVal;
        retVal = str1.equals(str2);
        System.out.println("Returned Value : " + retVal);
    
        retVal = str1.equals(str3);
        System.out.println("Returned Value : " + retVal);

        //String 객체의 주소가 같은지 판단
        System.out.println("Returned Value : " + str1 == str2);
        System.out.println("Returned Value : " + str1 == str3);

    }
}