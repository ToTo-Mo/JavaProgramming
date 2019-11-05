package Task.Login;

import java.net.*;
import java.io.*;

public class Server {
	int PORT = 3000;

	ServerSocket serverSocket;
	Socket socket;
	OutputStream writer;
	InputStream reader;

	Protocol protocol;

	static int LIMIT_ID_CHECK = 3; // 최대 ID 입력 횟수
	static int LIMIT_PW_CHECK = 3; // 최대 PW 입력 횟수

	public Server(int PORT) throws IOException {
		this.PORT = PORT;
		serverSocket = new ServerSocket(PORT);
		System.out.println("클라이언트 접속 대기중...");
		socket = serverSocket.accept();
		System.out.println("클라이언트 접속");

		writer = socket.getOutputStream();
		reader = socket.getInputStream();
	}

	//로그인 완료후 종료
	public void stopServer() throws IOException {
		send(Protocol.PT_EXIT);
		System.out.println("서버종료");
	}

	//로그인 실패로 인한 종료
	public void stopClient() throws IOException {
		send(Protocol.PT_EXIT);
		System.out.println("클라이언트 연결 종료");
	}

	//ID 확인
	public void checkID(String id) throws IOException {
		System.out.println("[" + socket.getLocalSocketAddress() + "][ID 확인 요청] : " + id);

		if (id.equals("20161213")) {
			send(Protocol.PT_RESULT, Protocol.PT_RESULT_ID_SUCCESS);
			send(Protocol.PT_REQ, Protocol.PT_REQ_PW);
		} else {
			LIMIT_ID_CHECK--;

			if (LIMIT_ID_CHECK == 0)
				stopClient();

			send(Protocol.PT_RESULT, Protocol.PT_RESULT_ID_FAIL);
			send(Protocol.PT_REQ, Protocol.PT_REQ_ID);
		}
	}

	//PASSWORD 확인
	public void checkPW(String password) throws IOException {
		System.out.println("[" + socket.getLocalSocketAddress() + "][PASSWORD 확인 요청] : " + password);

		if (password.equals("1234"))
			send(Protocol.PT_RESULT, Protocol.PT_RESULT_PW_SUCCESS);

		else {
			LIMIT_PW_CHECK--;

			if (LIMIT_PW_CHECK == 0)
				stopClient();

			send(Protocol.PT_RESULT, Protocol.PT_RESULT_PW_FAIL);
			send(Protocol.PT_REQ, Protocol.PT_REQ_PW);
		}
	}

	//패킷 전송 
	public void send(int protocolType, int code) throws IOException {
		protocol = new Protocol(protocolType, code);
		writer.write(protocol.getPacket());
	}

	//패킷 전송
	public void send(int protocolType) throws IOException {
		protocol = new Protocol(protocolType);
		writer.write(protocol.getPacket());
	}

	//패킷 수신
	public void receive() throws IOException {
		protocol = new Protocol();
		byte[] buffer = this.protocol.getPacket();
		reader.read(buffer);
		int protocolType = buffer[0];
		int code = buffer[1];
		protocol.setPacket(protocolType, code, buffer); // 패킷 타입을 Protocol 객체의 packet 멤버변수에 buf를 복사
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		int PORT = 3000;
		Server server = new Server(PORT);
		boolean program_stop = false;

		server.send(Protocol.PT_REQ, Protocol.PT_REQ_ID);
		while (true) {
			server.receive();
			int protocolType = server.protocol.getProtocolType();
			int code = server.protocol.getCode();

			switch (protocolType) {

			case Protocol.PT_EXIT:
				server.stopServer();
				program_stop = true;
				break;

			case Protocol.PT_RES:
				if (code == Protocol.PT_RES_ID)
					server.checkID(server.protocol.getId());

				else if (code == Protocol.PT_RES_PW)
					server.checkPW(server.protocol.getPassword());

				break;
			}// end switch

			if (program_stop)
				break;
		} // end while
	}
}