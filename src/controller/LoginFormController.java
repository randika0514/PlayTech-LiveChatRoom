package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtUserName;

    static String userName;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        userName=txtUserName.getText();

        Stage stg = (Stage) txtUserName.getScene().getWindow();
        stg.close();
        Stage stg2=new Stage();
        stg2.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientForm.fxml"))));
        stg2.setResizable(false);
        stg2.setTitle("PlayTech Live Chat Room");
        stg2.centerOnScreen();
        stg2.show();
    }
}
