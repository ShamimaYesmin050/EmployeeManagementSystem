package ui;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import models.Attendance;

public class AttendanceScreen {

    private ObservableList<Attendance> attendanceList =
            FXCollections.observableArrayList();

    public Scene createScene(Stage stage) {

        Label title =
                new Label("Attendance Management");

        TextField idField =
                new TextField();

        idField.setPromptText("Employee ID");

        TextField nameField =
                new TextField();

        nameField.setPromptText("Employee Name");

        Button checkInBtn =
                new Button("Check In");

        Button absentBtn =
                new Button("Mark Absent");

        Button backBtn =
                new Button("Back");

        TableView<Attendance> table =
                new TableView<>();

        TableColumn<Attendance,Integer> idCol =
                new TableColumn<>("ID");

        idCol.setCellValueFactory(
                new PropertyValueFactory<>("employeeId")
        );

        TableColumn<Attendance,String> nameCol =
                new TableColumn<>("Name");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("employeeName")
        );

        TableColumn<Attendance,String> statusCol =
                new TableColumn<>("Status");

        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        table.getColumns().addAll(
                idCol,
                nameCol,
                statusCol
        );

        table.setItems(attendanceList);

        checkInBtn.setOnAction(e -> {

            try {

                String status;

                if(LocalTime.now().isAfter(
                        LocalTime.of(9,0))) {

                    status = "Late";

                } else {

                    status = "Present";
                }

                Attendance attendance =
                        new Attendance(

                                Integer.parseInt(
                                        idField.getText()
                                ),

                                nameField.getText(),

                                LocalDate.now(),

                                LocalTime.now(),

                                null,

                                status
                        );

                attendanceList.add(attendance);

                idField.clear();
                nameField.clear();

            } catch(Exception ex) {

                System.out.println(
                        "Invalid Input"
                );
            }
        });

        absentBtn.setOnAction(e -> {

            try {

                Attendance attendance =
                        new Attendance(

                                Integer.parseInt(
                                        idField.getText()
                                ),

                                nameField.getText(),

                                LocalDate.now(),

                                null,

                                null,

                                "Absent"
                        );

                attendanceList.add(attendance);

                idField.clear();
                nameField.clear();

            } catch(Exception ex) {

                System.out.println(
                        "Invalid Input"
                );
            }
        });

        backBtn.setOnAction(e -> {

            DashboardHome home =
                    new DashboardHome();

            stage.setScene(
                    home.createScene(stage)
            );
        });

        HBox form =
                new HBox(
                        10,
                        idField,
                        nameField,
                        checkInBtn,
                        absentBtn
                );

        VBox root =
                new VBox(
                        15,
                        title,
                        form,
                        table,
                        backBtn
                );

        root.setPadding(
                new Insets(20)
        );

        return new Scene(
                root,
                1000,
                700
        );
    }
}
