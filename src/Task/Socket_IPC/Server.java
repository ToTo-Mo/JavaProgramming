package Task.Socket_IPC;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
            System.out.println("서버입니다");
            /* now listen for connections */
            while (true) {
                Socket client = sock.accept();
                PrintWriter pout = new
                PrintWriter(client.getOutputStream(), true);
                /* write the Date to the socket */
                System.out.println("클라이언트 접속 성공.");
                pout.println("20161213 최범휘");
                /* close the socket and resume */
                /* listening for connections */
                client.close();
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}