package Chat_Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Client {
    Socket socket; 
    
    public Client(Socket socket){
        this.socket = socket;
        receive();
    }

    private void receive() {
        Runnable thread = new Runnable(){
            @Override
            public void run() {
                try {
                    while(true){
                        InputStream reader = socket.getInputStream();
                        byte[] buffer = new byte[512];
                        int length = reader.read(buffer);
                        while(length == -1) throw new IOException();

                        System.out.println("[메시지 수신 성공] "
                            +socket.getRemoteSocketAddress()
                            +": "+Thread.currentThread().getName());
                        String message = new String(buffer,"UTF-8");
                        for(Client client : Main.clients){
                            client.send(message);
                        }
                    }
                } catch (Exception e) {
                    try {
                        System.out.println("[메시지 수신 오류]"
                            +socket.getRemoteSocketAddress()
                            +": "+Thread.currentThread().getName());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                   e.printStackTrace();
                }
            }
        };
        Main.threadPool.submit(thread);
    }

    private void send(String message){
        Runnable thread = new Runnable(){
            @Override
            public void run() {
                try {
                    OutputStream writer = socket.getOutputStream();
                    byte[] buffer = message.getBytes("UTF-8");
                    writer.write(buffer);
                    writer.flush();
                } catch (Exception e) {
                    try {
                        System.out.println("[메시지 전송 오류] "
                            +socket.getRemoteSocketAddress()
                            +": "+Thread.currentThread().getName());
                        Main.clients.remove(Client.this);
                        socket.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
        Main.threadPool.submit(thread);
    }
}