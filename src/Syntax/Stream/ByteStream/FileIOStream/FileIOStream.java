package Syntax.ByteStream.FileIOStream;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream("src/Syntax/Stream/ByteStream/test.txt");
            int num[]= {2,3,-2,87,351};
            byte b[]= {7,50,3,4,1,24};
            for(int i=0; i<num.length; i++)
                out.write(num[i]);
            out.write('\n');
            out.write(b);
            out.close();
            System.out.println("성공적으로 마쳤습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            FileInputStream in = new FileInputStream("src/Syntax/Stream/ByteStream/test.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.println((int) c);
            }

            in.close();
        } catch (IOException e) {
            // 파일이 존재하지 않는 경우 여러 에러가 발생 가능
            e.printStackTrace();
        }
    }

}