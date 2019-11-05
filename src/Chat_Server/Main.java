package Chat_Server;

import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static ExecutorService threadPool;
    public static Vector<Client> clients = new Vector<Client>();

    ServerSocket serverSocket;

    public void startServer(String IP, int PORT){
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(IP, PORT));
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


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("나눔코딕",15));
        root.setCenter(textArea);

        Button toggleButton = new Button("시작하기");
        toggleButton.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
        root.setBottom(toggleButton);

        String IP = "localhost";
        int PORT = 4674;

        toggleButton.setOnAction(event ->{
            if(toggleButton.getText().equals("시작하기")){
                startServer(IP, PORT);
                Platform.runLater(() ->{
                    String message = String.format("[서버시작]\n", IP,PORT);
                    textArea.appendText(message);
                    toggleButton.setText("종료하기");
                });
            }else{
                stopServer();
                Platform.runLater(()->{
                    String message = String.format("[종료하기]\n", IP,PORT);
                    textArea.appendText(message);
                    toggleButton.setText("시작하기");
                });
            }
        });

        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("[채팅서버]");
        primaryStage.setOnCloseRequest(event->stopServer());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}