package Syntax.PrintWriter;

import java.io.*;
import java.util.*;

public class Program{
    public final static String READFILE = "src/Syntax/PrintWriter/read.txt";
    public final static String WRITEFILE = "src/Syntax/PrintWriter/write.txt";
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner inFile = new Scanner(new File(READFILE));
        PrintWriter outFile = new PrintWriter(new File(WRITEFILE));

        int lineNumber = 1;
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            outFile.println("/* " + lineNumber + " */ " + line);
			lineNumber++;
        }
        
        outFile.close();
        inFile.close();
		System.out.println("작업을 성공적으로 마쳤습니다.");
    }
}