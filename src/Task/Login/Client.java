package Task.Login;

import java.io.*;
import java.net.*;

public class Client {

    public final static String IP = "localhost";
    public final static int PORT = 3000;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(IP, PORT);

        OutputStream writer = socket.getOutputStream();
        InputStream reader = socket.getInputStream();

        Protocol protocol = new Protocol();
        byte[] buf = protocol.getPacket(); // 기본 버퍼 사이즈를 1000으로 할당

        while (true) {
            reader.read(buf);
            int packetType = buf[0];
            int code = buf[1];
            protocol.setPacket(packetType, code, buf);

            if (packetType == Protocol.PT_EXIT) {
                System.out.println("클라이언트 종료");
                break;
            }

            switch (packetType) {
            case Protocol.PT_REQ:
                BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

                if (code == Protocol.PT_REQ_ID) {
                    protocol = new Protocol(Protocol.PT_RES, Protocol.PT_RES_ID);

                    String id;
                    System.out.print("아이디 : ");
                    while((id = userIn.readLine()).length() > Protocol.LEN_LOGIN_ID){
                        System.out.println("길이 초과!!.");
                        System.out.print("아이디 : ");
                    }

                    protocol.setId(id);
                    writer.write(protocol.getPacket());

                } else if (code == Protocol.PT_REQ_PW) {
                    String pw;
                    System.out.print("비밀번호 : ");
                    while((pw = userIn.readLine()).length() > Protocol.LEN_LOGIN_PW){
                        System.out.println("길이 초과!!");
                        System.out.print("비밀번호 : ");
                    }

                    protocol = new Protocol(Protocol.PT_RES, Protocol.PT_RES_PW);
                    String password = userIn.readLine();
                    protocol.setPassword(password);
                    writer.write(protocol.getPacket());
                }
                break;

            case Protocol.PT_RESULT:
                if (code == Protocol.PT_RESULT_ID_SUCCESS)
                    System.out.println("아이디 확인");

                else if (code == Protocol.PT_RESULT_ID_FAIL)
                    System.out.println("아이디 없음");

                else if (code == Protocol.PT_RESULT_PW_SUCCESS) {
                    System.out.println("로그인 완료");
                    protocol = new Protocol(Protocol.PT_EXIT);
                    writer.write(Protocol.PT_EXIT);

                } else if (code == Protocol.PT_RESULT_PW_FAIL)
                    System.out.println("비밀번호 불일치");
            
                break;
            }
        }
        writer.close();
        reader.close();
        socket.close();
    }
}