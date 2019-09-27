package Syntax.String;

public class Split{

    public static void main(String[] args){
        String delimeter = " ";
        String words = "minsu : hello my name is minsu \nminoh : nice to meet you, how is going?";
        String[] split = null;

        split = words.split(delimeter);
        for(String token : split)
            System.out.print(token + "-");
    }
}