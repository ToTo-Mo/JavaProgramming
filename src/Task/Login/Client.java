package Task.Login;

import java.io.*;
import java.nio.*;
import java.net.*;

public class Client{

    public final static String IP = "localhost";
    public final static int PORT = 3000;

    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket(IP, PORT);

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        Protocol protocol = new Protocol();
        byte[] buf = protocol.getPacket(); // 기본 버퍼 사이즈를 1000으로 할당

        while (true) {
            in.read(buf);
            int packetType = buf[0];
            protocol.setPacket(packetType, buf);
            if (packetType == Protocol.PT_EXIT) {
                System.out.println("클라이언트 종료");
                break;
            }

            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
            switch (packetType) {
                case Protocol.PT_REQ:
                    
                    System.out.println("서버가 ID 요청");
                    System.out.print("아이디 : ");
                    String id = userIn.readLine();
                    protocol = new Protocol(Protocol.PT_RES_ID);
                    protocol.setId(id);
                    out.write(protocol.getPacket());
                    System.out.println("ID 정보 전송");
                    break;

                case Protocol.PT_ID_RESULT:
                    String result = protocol.getIDResult();
                    if(result == "1")
                        System.out.println("아이디 확인");
                    else if(result == "2")
                        System.out.println("아이디 없음");
                    break;

                case Protocol.PT_REQ_PW:
                    System.out.println("서버가 PW 요청");
                    System.out.print("암호 : ");
                    String pwd = userIn.readLine();
                    protocol.setPassword(pwd);
                    System.out.println("PW 정보 전송");
                    out.write(protocol.getPacket());
                    break;

                case Protocol.PT_RES_PW:
                    System.out.println("비밀번호 확인");
                    break;
            }
            out.close();
            in.close();
        socket.close();
        }
    }
}