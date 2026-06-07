package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/views/Login.fxml"));

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
                getClass().getResource("/styles/style.css").toExternalForm()
        );

        stage.setTitle("Employee Management with Attendance System UI");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}