package Task.Socket_IPC;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
        /* make connection to server socket */
        Socket sock = new Socket("127.0.0.1",6013);
        BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        System.out.println("클라이언트 서버 연결 성공");
        /* read the date from the socket */
        String line;
        while ( (line = reader.readLine()) != null)
        System.out.println(line);
        /* close the socket connection*/
        sock.close();
        }
        catch (IOException ioe) {
        System.err.println(ioe);
        }
    }
}