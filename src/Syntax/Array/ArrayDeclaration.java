package Syntax.Array;

import Syntax.Finalize.Cat;

public class ArrayDeclaration
{
    public static void main()
    {
        Cat[] catArray = new Cat[5];

        for(Cat cat : catArray)
        {
            cat = new Cat();
        }
        
        for(Cat cat : catArray)
        {
            System.out.println(cat.toString());
        } 
    }
}