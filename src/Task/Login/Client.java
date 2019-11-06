package Task.Login;

import java.io.*;
import java.net.*;

public class Client {

    int PORT = 3000;
    String IP = "localhost";

    Socket socket;
    OutputStream writer;
    InputStream reader;

    Protocol protocol;

    public Client(String IP, int PORT) throws UnknownHostException, IOException {
        this.IP = IP;
        this.PORT = PORT;

        socket = new Socket(IP, PORT);
        writer = socket.getOutputStream();
        reader = socket.getInputStream();
    }

    //로그인 완료 후 종료 신호
    public void stopServer() throws IOException {
        send(Protocol.PT_EXIT);
        System.out.println("클라이언트 종료");
    }

    // 패킷 전송
    // data는 code에 따라 id와 password로 구분
    public void send(int packetType, int code, String data) throws IOException {
        protocol = new Protocol(packetType, code, data);
        writer.write(protocol.getPacket());
    }

    // 패킷 전송
    public void send(int packetType, int code) throws IOException {
        protocol = new Protocol(packetType, code);
        writer.write(protocol.getPacket());
    }

    // 패킷 전송
    public void send(int packetType) throws IOException {
        protocol = new Protocol(packetType);
        writer.write(protocol.getPacket());
    }

    //패킷 수신
    public void receive() throws IOException {
        protocol = new Protocol();
        byte[] buffer = this.protocol.getPacket();
        reader.read(buffer);
        int protocolType = buffer[0];
        int code = buffer[1];
        protocol.setPacket(protocolType, code, buffer);
    }

    // ID 입력
    public String inputID() throws IOException {
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        String id;
        System.out.print("아이디 : ");
        while ((id = userIn.readLine()).length() > Protocol.LEN_LOGIN_ID) {
            System.out.println("길이 초과!!.");
            System.out.print("아이디 : ");
        }

        return id;
    }

    // PASSWORD 입력
    public String inputPW() throws IOException {
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        String password;
        System.out.print("비밀번호 : ");
        while ((password = userIn.readLine()).length() > Protocol.LEN_LOGIN_ID) {
            System.out.println("길이 초과!!.");
            System.out.print("비밀번호 : ");
        }

        return password;
    }

    public static void main(String[] args) throws IOException {

        String IP = "localhost";
        int PORT = 3000;
        Client client = new Client(IP, PORT);

        while (true) {
            client.receive();
            int protocolType = client.protocol.getProtocolType();
            int code = client.protocol.getCode();

            if (code == Protocol.PT_EXIT) {
                client.stopServer();
                break;
            }
            
            switch (protocolType) {
            case Protocol.PT_REQ:
                if (code == Protocol.PT_REQ_ID) {
                    String id = client.inputID();
                    client.send(Protocol.PT_RES, Protocol.PT_RES_ID, id);

                } else if (code == Protocol.PT_REQ_PW) {
                    String password = client.inputPW();
                    client.send(Protocol.PT_RES, Protocol.PT_RES_PW, password);
                }
                break;

            case Protocol.PT_RESULT:
                if (code == Protocol.PT_RESULT_ID_SUCCESS)
                    System.out.println("아이디 확인");

                else if (code == Protocol.PT_RESULT_ID_FAIL)
                    System.out.println("아이디 없음");

                else if (code == Protocol.PT_RESULT_PW_SUCCESS) {
                    System.out.println("로그인 완료");
                    client.send(Protocol.PT_EXIT);

                } else if (code == Protocol.PT_RESULT_PW_FAIL)
                    System.out.println("비밀번호 불일치");

                break;
            }
        }
    }
}