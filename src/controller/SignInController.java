package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public JFXButton btnLogin;
    public Label lblOnAction;
    public AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtUsername.requestFocus();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
            login();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void UsernameKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){
            pwdPassword.requestFocus();
        }
    }

    public void PasswordKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void mainForm() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Form");
        stage.setResizable(false);

    }

    private void login() throws IOException {
        String user = txtUsername.getText();
        String password = pwdPassword.getText();

        if (0 < user.length() && 0 < password.length()){
             if(user.equalsIgnoreCase("Shehan")&& password.equalsIgnoreCase("1234")) {
              mainForm();
            }else {
                txtUsername.setText("");
                pwdPassword.clear();
            }

        }

    }
}
