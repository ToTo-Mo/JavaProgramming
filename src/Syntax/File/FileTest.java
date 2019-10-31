package Syntax.File;

import java.io.*;

public class FileTest {
    public static void main(String[] args){
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {		
            System.out.println(" 파일 명 입력 >> ");
            String str = in.readLine();
            File f = new File(str);
            if(f.exists()){
                if(f.isFile()) {
                    System.out.println("파일입니다");
                    long t = f.lastModified();
                    System.out.print("파일 이름 : " + f.getName());
                    System.out.print("\t파일 크기: " + f.length());
                    System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t, t, t, t);
                }

                else if (f.isDirectory()) {
                    System.out.println("디렉토리입니다");
                    File [] fnames = f.listFiles();
                    for(File sf : fnames) {
                        long t = sf.lastModified(); 
                        System.out.print("파일 이름 : " + sf.getName());
                        System.out.print("\t파일 크기: " + sf.length()); 
                        System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t, t, t, t);
                    }
                }
            }else {
                System.out.println("입력한 이름의 파일이나 디렉토리가 존재하지 않습니다.");
            }
            
            in.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}