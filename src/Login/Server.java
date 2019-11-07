package Login;

import java.net.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	int PORT = 3000;

	ServerSocket serverSocket;

	public static ExecutorService threadPool;
    public static Vector<Client> clients = new Vector<Client>();

	Socket socket;
	OutputStream writer;
	InputStream reader;

	Protocol protocol;

	static int LIMIT_ID_CHECK = 3; // 최대 ID 입력 횟수
	static int LIMIT_PW_CHECK = 3; // 최대 PW 입력 횟수

	public void startServer(int PORT){
		try{
            serverSocket = new ServerSocket(PORT);
        } catch(Exception e){
            e.printStackTrace();
            if(!serverSocket.isClosed()){
                stopServer();
            }
            return ;
		}
		
		Runnable thread = new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Socket socket = serverSocket.accept();
                        clients.add(new Client(socket));
                        System.out.println("[클라이언트 접속] "
                            +socket.getRemoteSocketAddress()
                            +": "+Thread.currentThread().getName());
                    } catch (Exception e) {
                        if(!serverSocket.isClosed()){
                            stopServer();
                        }
                        break;
                    }
                }
            }
        };
        threadPool = Executors.newCachedThreadPool();
        threadPool.submit(thread);
	}

	//로그인 완료후 종료
	public void stopServer(){
		try {
            //현재 작동중인 모든 소켓 종료
            Iterator<Client> iterator = clients.iterator();
            while(iterator.hasNext()){
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }

            // 서버 소켓 닫기
            if(serverSocket != null && !serverSocket.isClosed()){
                serverSocket.close();
            }
            
            // 스레드풀 닫기
            if(threadPool != null && !threadPool.isShutdown()){
                threadPool.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	//로그인 실패로 인한 종료
	public void stopClient() throws IOExc
	?eption {
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