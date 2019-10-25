package Syntax.Stream.CharacterStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOStream {
    public static void main(String[] args) {
        OutputStreamWriter fout = null;
        double d = 32.3;
        try {
            // 결국 문자도 Byte로 구성 되있으므로 FileOutputStream을 사용한다
            String encoding = "UTF-16";
            //OutputStreamWriter는 별도의 인코딩도 지정할 수 있다. 기본값은 utf-8
            fout = new OutputStreamWriter(new FileOutputStream("src/Syntax/Stream/CharacterStream/test.txt"),encoding);

            //getEncoding() : OutputStreamWrtier의 현재 인코딩 방식
            System.out.println("인코딩 : " + fout.getEncoding());
            fout.write("한글\n");
            fout.write(Double.toString(d)); // 문자열로 변환 후 저장

            fout.close();
            System.out.println("성공적으로 쓰기를 마쳤습니다.");

            // 인코딩과 디코딩이 다른 경우 문자가 꺠짐
			InputStreamReader fin = new InputStreamReader(new FileInputStream("src/Syntax/Stream/CharacterStream/test.txt")
            , "UTF-8");

            int c;
            System.out.println("디코딩 : " + fin.getEncoding());
            while ((c = fin.read()) != -1) 
                System.out.print((char)c);
            
            fout.close();
            fin.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}