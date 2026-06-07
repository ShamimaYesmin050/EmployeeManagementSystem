package employeemanagementsystemant;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.LoginScreen;

public class EmployeeManagementSystemAnt extends Application {

    @Override
    public void start(Stage primaryStage) {

        LoginScreen login = new LoginScreen();

        Scene scene =
                login.createScene(primaryStage);

        primaryStage.setTitle(
                "Employee Management System"
        );

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
