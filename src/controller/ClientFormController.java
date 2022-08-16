package controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFormController extends Thread{
    public AnchorPane chatContext;
    public Label lblUserName;
    public JFXTextArea txtAreaClient;
    public TextField txtMsg;

    BufferedReader bufferedReader;
    PrintWriter printWriter;
    Socket socket;

    public void initialize(){
        try {
            socket=new Socket("localhost",5000);
            System.out.println("Socket Connected...");
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter=new PrintWriter(socket.getOutputStream(),true);
            this.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            while (true){
                String message= bufferedReader.readLine();
                String[] tokens = message.split(" ");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fullMessage=new StringBuilder();
                for (int i=1;i<tokens.length;i++){
                    fullMessage.append(tokens[i]);
                }
                System.out.println(fullMessage);

                System.out.println("cmd"+cmd+"     UserName"+lblUserName.getText());
                if (!cmd.equalsIgnoreCase(lblUserName.getText()+":")){
                    txtAreaClient.appendText(message+"\n");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnSendOnAction(ActionEvent actionEvent) {

    }
}
