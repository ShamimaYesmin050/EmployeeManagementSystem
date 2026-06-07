package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {

    public Scene createScene(Stage stage) {

        Label title =
                new Label("Employee Management System");

        TextField usernameField =
                new TextField();

        usernameField.setPromptText("Username");

        PasswordField passwordField =
                new PasswordField();

        passwordField.setPromptText("Password");

        Button loginButton =
                new Button("Login");

        VBox root =
                new VBox(15);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginButton
        );

        loginButton.setOnAction(e -> {

            if (usernameField.getText().equals("admin")
                    && passwordField.getText().equals("admin")) {

                DashboardHome home =
        new DashboardHome();

stage.setScene(
        home.createScene(stage)
);
            }
        });

        return new Scene(root, 1000, 700);
    }
}