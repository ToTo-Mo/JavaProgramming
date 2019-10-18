package Syntax.ByteStream.DataIOStream;

import java.io.*;

public class DataIOStream {
    public static void main(String[] args) {
        try {
            //FileIOStream의 단점인 원형의 자료형을 그대로 사용할 수 없다는 점을 보안
            DataOutputStream dos = new DataOutputStream(
                                    new FileOutputStream("src/Syntax/ByteStream/DataIOStream/test.txt"));
            boolean b = false;
            double d = 165.8;
            String str = "This is a test.";

            dos.writeBoolean(b);
            dos.writeDouble(d);
            dos.writeChars(str);

            dos.close();
            System.out.println("성공적으로 쓰기를 마쳤습니다.");
            
            DataInputStream dis = new DataInputStream(
                                    new FileInputStream("src/Syntax/ByteStream/DataIOStream/test.txt"));

            boolean b2 = dis.readBoolean();
            System.out.println(b2);
            double d2 = dis.readDouble();
            System.out.println(d2);
            char c;
            while (dis.available() > 0) { // 남아있는 바이트수 검사
                c = dis.readChar();
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}