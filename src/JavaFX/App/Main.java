package Syntax.JavaFX.App;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Main extends Application {

    @Override
    public void init() throws Exception{
        System.out.println(Thread.currentThread().getName() + ": init() 호출");
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println(Thread.currentThread().getName() + ": init() 호출");

            VBox root = new VBox();
            Button[] buttons = new Button[10];
            Button exit = new Button("종료");

            for(int i =0; i<10; i++){
                buttons[i] = new Button("hello");
            }

            root.getChildren().addAll(buttons);
            root.getChildren().add(exit);
            Scene scene = new Scene(root,400,400);
            primaryStage.setTitle("국밥집");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception{
        System.out.println(Thread.currentThread() + ": stop() 호출");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + ": main() 호출");
        launch(args);
    }
}