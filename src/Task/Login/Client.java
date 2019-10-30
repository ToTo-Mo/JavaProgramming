package Task.Login;

import java.io.*;
import java.net.*;

public class Client {

    public final static String IP = "localhost";
    public final static int PORT = 10101;

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

            if (protocol.REQ_ID_LIMIT == 0) {
                System.out.println("아이디 입력 횟수 초과");
                break;
            }
            if (protocol.REQ_PW_LIMIT == 0) {
                System.out.println("비밀번호 입력 횟수 초과");
            }

            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

            switch (packetType) {
                case Protocol.PT_REQ_ID:
                    System.out.println("서버가 ID 요청");
                    System.out.print("아이디 : ");
                    String id = userIn.readLine();
                    protocol.setId(id);
                    System.out.println("ID 정보 전송");
                    out.write(protocol.getPacket());
                    break;

                case Protocol.PT_REQ_PW:
                    System.out.println("서버가 PW 요청");
                    System.out.print("암호 : ");
                    String pwd = userIn.readLine();
                    protocol.setPassword(pwd);
                    System.out.println("PW 정보 전송");
                    out.write(protocol.getPacket());
                    break;

                case Protocol.PT_ID_RESULT:

                case Protocol.PT_LOGIN_RESULT:
                    System.out.println("서버가 로그인 결과 전송.");
                    String result = protocol.getLoginResult();
                    if (result.equals("1")) {
                        System.out.println("로그인 성공");
                    } else if (result.equals("2")) {
                        System.out.println("암호 틀림");
                    } else if (result.equals("3")) {
                        System.out.println("아이디가 존재하지 않음");
                        protocol.REQ_ID_LIMIT--;
                    }
                    protocol = new Protocol(Protocol.PT_EXIT);
                    System.out.println("종료 패킷 전송");
                    out.write(protocol.getPacket());
                    break;
            }
            out.close();
            in.close();
            socket.close();
        }

    }
}