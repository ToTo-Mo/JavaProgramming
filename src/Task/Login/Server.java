package Task.Login;

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		ServerSocket sSocket = new ServerSocket(3000);
		System.out.println("클라이언트 접속 대기중...");
		Socket socket = sSocket.accept();
		System.out.println("클라이언트 접속");

		// 바이트 배열로 전송할 것이므로 필터 스트림 없이 Input/OutputStream만 사용해도 됨
		OutputStream writer = socket.getOutputStream();
		InputStream reader = socket.getInputStream();

		// 로그인 정보 요청용 프로토콜 객체 생성 및 전송
		Protocol protocol = new Protocol(Protocol.PT_REQ,Protocol.PT_REQ_ID);
		writer.write(protocol.getPacket());

		boolean program_stop = false;

		protocol = new Protocol(); // 새 Protocol 객체 생성 (기본 생성자)
		byte[] buf = protocol.getPacket(); // 기본 생성자로 생성할 때에는 바이트 배열의 길이가 1000바이트로 지정됨

		while (true) {
			reader.read(buf);
			int packetType = buf[0];
			int code = buf[1]; // 수신 데이터에서 패킷 타입 얻음
			protocol.setPacket(packetType, code, buf); // 패킷 타입을 Protocol 객체의 packet 멤버변수에 buf를 복사

			switch (packetType) {
			case Protocol.PT_EXIT: // 프로그램 종료 수신
				protocol = new Protocol(Protocol.PT_EXIT);
				writer.write(protocol.getPacket());
				program_stop = true;
				System.out.println("서버종료");
				break;

			// Client의 응답 확인
			case Protocol.PT_RES:
				// Client의 아이디 확인
				if (code == Protocol.PT_RES_ID) {
					if (protocol.getId().equals("20161213")) {
						//아이디 확인 완료 응답
						protocol = new Protocol(Protocol.PT_RESULT, Protocol.PT_RESULT_ID_SUCCESS);
						writer.write(protocol.getPacket());

						//비밀번호 입력 요청
						protocol = new Protocol(Protocol.PT_REQ, Protocol.PT_REQ_PW);
						writer.write(protocol.getPacket());
					} else {
						// 아이디의 최대 입력 횟수 3회
						Protocol.LIMIT_ID_CHECK--;



						// 아이디의 입력 횟수를 초과한 경우 종료됨
						if (Protocol.LIMIT_ID_CHECK == 0) {
							protocol = new Protocol(Protocol.PT_EXIT);
							writer.write(protocol.getPacket());
							program_stop = true;
							System.out.println("클라이언트 연결 종료");
						} else {
							protocol = new Protocol(Protocol.PT_RESULT, Protocol.PT_RESULT_ID_FAIL);
							writer.write(protocol.getPacket());

							protocol = new Protocol(Protocol.PT_REQ,Protocol.PT_REQ_ID);
							writer.write(protocol.getPacket());
						}
					}
				// Clinet의 비밀번호 확인
				} else if (code == Protocol.PT_RES_PW) {
					if (protocol.getPassword().equals("1234")) {
						protocol = new Protocol(Protocol.PT_RESULT, Protocol.PT_RESULT_PW_SUCCESS);
						writer.write(protocol.getPacket());


					} else {
						// 비밀번호의 최대 입력 횟수 3회
						Protocol.LIMIT_PW_CHECK--;

						// 비밀번호의 입력 횟수를 초과한 경우 종료됨
						if (Protocol.LIMIT_PW_CHECK == 0) {
							protocol = new Protocol(Protocol.PT_EXIT);
							writer.write(protocol.getPacket());
							program_stop = true;
							System.out.println("클라이언트 연결 종료");
						}
						else{
							protocol = new Protocol(Protocol.PT_RESULT, Protocol.PT_RESULT_PW_FAIL);
							writer.write(protocol.getPacket());

							protocol = new Protocol(Protocol.PT_REQ, Protocol.PT_REQ_PW);
							writer.write(protocol.getPacket());
						}
					}
				}
				break;

			}// end switch

			if (program_stop)
				break;
		} // end while

		reader.close();
		writer.close();
		socket.close();
	}
}