package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private StackPane contentPane;

    @FXML
    private void showDashboard() {

        contentPane.getChildren().clear();
        contentPane.getChildren().add(
                new Label("Dashboard Page"));

    }

    @FXML
    private void showEmployee() {

        contentPane.getChildren().clear();
        contentPane.getChildren().add(
                new Label("Employee Page"));

    }

    @FXML
    private void showAttendance() {

        contentPane.getChildren().clear();
        contentPane.getChildren().add(
                new Label("Attendance Page"));

    }

    @FXML
    private void showReports() {

        contentPane.getChildren().clear();
        contentPane.getChildren().add(
                new Label("Reports Page"));

    }

    @FXML
    private void logout() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/views/Login.fxml"));

            Scene scene =
                    new Scene(loader.load());

            Stage stage =
                    (Stage) contentPane.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
