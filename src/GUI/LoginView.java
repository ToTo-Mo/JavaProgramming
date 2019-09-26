package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import Utility.DBConnection;


public class LoginView extends JFrame {
    private MainView main;

    private JButton btnLogin;
    private JButton btnInit;
    private JPasswordField passText;
    private JTextField userText;
    private JLabel loginImage;
    private boolean bLoginCheck;
    public static void main(String[] args) {
        // new LoginView();
    }

    public LoginView() {
        // setting
        setTitle("로그인");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);

        // add
        add(panel);

        // visiible
        setVisible(true);
    }

    public void placeLoginPanel(JPanel panel) {
        GroupLayout layout = new GroupLayout(panel);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                    .addGap(0, 492, Short.MAX_VALUE)
        );
        panel.setLayout(layout);     
       
        BufferedImage img = null;
        try{
            File sourceImage = new File("src/Resource/LoingIcon.png");
            img = ImageIO.read(sourceImage);
        }catch(IOException e){
        }
        
        /*
        setBounds(int x, int y, int width, int height)
        x the new x-coordinate of this component

        y the new y-coordinate of this component

        width the new width of this component

        height the new height of this component
        */
        loginImage = new JLabel(new ImageIcon(img)); 
        loginImage.setBounds(300,100,360,100);
        panel.add(loginImage);

        userText = new JTextField(20);
        userText.setBounds(300, 380, 200, 40);
        panel.add(userText);
        
        passText = new JPasswordField(20);
        passText.setBounds(300, 430, 200, 40);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
       
        // btnInit = new JButton("Reset");
        // btnInit.setBounds(10, 80, 100, 25);
        // panel.add(btnInit);
        // btnInit.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         userText.setText("");
        //         passText.setText("");
        //     }
        // });
       
        btnLogin = new JButton("Login");
        btnLogin.setBounds(300, 480, 200, 40);
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();
            }
        });


    }
   
    public void isLoginCheck(){
        
        PreparedStatement st;
        String query = "";

        if(userText.getText().equals("test") && new String(passText.getPassword()).equals("1234")){
            JOptionPane.showMessageDialog(null, "Success");
            bLoginCheck = true;
           
            // 로그인 성공이라면 매니져창 뛰우기
            if(isLogin()){
                main.showFrameTest(); // 메인창 메소드를 이용해 창뛰우기
            }                  
        }else{
            JOptionPane.showMessageDialog(null, "Faild");
        }
    }
 
   
    // MainView와 연동
    public void setMain(MainView main) {
        this.main = main;
    }
   
 
    public boolean isLogin() {     
        return bLoginCheck;
    }
 
}