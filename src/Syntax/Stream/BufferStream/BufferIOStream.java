package Syntax.Stream.BufferStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.*;

public class BufferIOStream {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
        try {
            int c;
            System.out.println(">> ");
            while ((c = in.read()) != 13) {
                out.write(c);
            }
            System.out.println("성공적으로 쓰기를 마쳤습니다.");
            // 버퍼 크기를 5로 설정하여 5글자 출력 2글자는 버퍼에 남음
            out.flush(); // 버퍼에 남아 있던 문자 출력
            if (in != null) {
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}