package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {

            try {

                Parent root = FXMLLoader.load(
                        getClass().getResource("/views/Dashboard.fxml"));

                Stage stage = (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {

                e.printStackTrace();

            }

        } else {

            messageLabel.setText("Invalid Username or Password");

        }
    }
}