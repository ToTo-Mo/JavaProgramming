package Example.Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String[] args) throws InterruptedException {
        ObjectInputStream din;
        ObjectOutputStream dout;
        int port1 = 3001; // 송신후 수신
        int port2 = 3002; // 수신 전담

        System.out.println("ClientMain Start.");
        // System.out.println("ip:" + args[0] + ", port:" + args[1]); // argument로 IP와
        // 포트를 입력할 수 있다.

        // 수신 Thread
        Thread.sleep(100);
        FileReceiveThread frt;
        frt = new FileReceiveThread("127.0.0.1", port1); // 로컬서버 port1으로 접속
        frt.start(); // frt.run()으로 실행하지 않는다.

        // 수신 Thread
        Thread.sleep(100);
        FileReceiveThread frt2;
        frt2 = new FileReceiveThread("127.0.0.1", port2); // 로컬서버 port1으로 접속
        frt2.start(); // frt2.run()으로 실행하지 않는다.
    }
}

class FileReceiveThread extends Thread {
    private Socket sock = null; // socket
    private ObjectInputStream din;
    private ObjectOutputStream dout;
    int port1 = 3001;
    int port2 = 3002;

    DataBuffer rb, sb;

    int serverPort; // server port
    String serverIp; // server Ip

    public FileReceiveThread(String serverIp, int serverPort) {
        this.serverPort = serverPort;
        this.serverIp = serverIp;
    }

    public void run() {
        // 서버측의 accept 보다 socket 생성자가 먼저 호출되면 연결이 실패하기 때문에
        // 100ms 만큼 쉬어준다.
        System.out.println("run():" + serverIp + "-" + serverPort);

        int cnt = 0;
        boolean connect = false; // Socket이 정상 접속되었는지 확인
        while (true) {
            try {
                if (connect == false) {
                    sock = new Socket(serverIp, serverPort);
                    if (sock != null) {
                        dout = new ObjectOutputStream(sock.getOutputStream());
                        din = new ObjectInputStream(sock.getInputStream());
                        connect = true;
                    }
                }

                if (serverPort == port1) { // 데이터 송신후 바로 데이터 수신, 3초 간격으로 반복
                    sb = new DataBuffer(cnt++, "CLIENT SEND");
                    System.out.println(sb.mIdx + ":" + sb.mData);
                    dout.writeObject(sb);

                    Object obj = din.readObject();
                    rb = (DataBuffer) obj;
                    if (rb == (DataBuffer) null) {
                        sock.close();
                        sock = null;
                        connect = false;
                        break;
                    }
                    commServerData1(rb);
                    Thread.sleep(3000); // 3초 대기
                }

                if (serverPort == port2) { // 서버로부터 데이터 수신
                    Object obj = din.readObject();
                    rb = (DataBuffer) obj;
                    if (rb == (DataBuffer) null) {
                        sock.close();
                        sock = null;
                        connect = false;
                        break;
                    }
                    commServerData2(rb);
                }
            } catch (EOFException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (ConnectException e) { // connect 시도시 실패한 경우
                e.printStackTrace();
                try {
                    Thread.sleep(5000);
                    sock = null;
                    connect = false;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            } catch (SocketException e) { // 서버에서 접속을 해제한 경우
                e.printStackTrace();
                try {
                    Thread.sleep(5000);
                    sock = null;
                    connect = false;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } // try
        } // while
    }

    private void commServerData1(DataBuffer buffer) {
        System.out.println("+++ data from server1: " + rb.mIdx + "," + rb.mData);
    }

    private void commServerData2(DataBuffer buffer) {
        System.out.println("--- data from server2: " + rb.mIdx + "," + rb.mData);
    }

}

class DataBuffer implements Serializable {
    int mIdx;
    String mData;

    DataBuffer(int idx, String data) {
        this.mIdx = idx;
        this.mData = data;
    }

    public String toString() {
        return "" + mIdx + ":" + mData;
    }
}