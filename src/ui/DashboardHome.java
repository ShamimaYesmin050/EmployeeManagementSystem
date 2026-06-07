package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardHome {

    public Scene createScene(Stage stage) {

        Label title =
                new Label("Employee Management System");

        Button employeeBtn =
                new Button("Employee Management");

        Button attendanceBtn =
                new Button("Attendance Management");

        Button logoutBtn =
                new Button("Logout");

        employeeBtn.setOnAction(e -> {

            DashboardScreen dashboard =
                    new DashboardScreen();

            stage.setScene(
                    dashboard.createScene(stage)
            );
        });

        attendanceBtn.setOnAction(e -> {

            AttendanceScreen attendance =
                    new AttendanceScreen();

            stage.setScene(
                    attendance.createScene(stage)
            );
        });

        logoutBtn.setOnAction(e -> {

            LoginScreen login =
                    new LoginScreen();

            stage.setScene(
                    login.createScene(stage)
            );
        });

        VBox root =
                new VBox(
                        20,
                        title,
                        employeeBtn,
                        attendanceBtn,
                        logoutBtn
                );

        root.setPadding(
                new Insets(30)
        );

        return new Scene(
                root,
                800,
                600
        );
    }
}
