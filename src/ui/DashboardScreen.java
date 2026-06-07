package ui;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import models.Employee;
import utils.EmployeeFileManager;

public class DashboardScreen {

    private ObservableList<Employee> employees =
            FXCollections.observableArrayList();

    public DashboardScreen() {

        employees.addAll(
                EmployeeFileManager.loadEmployees()
        );
    }

    public Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        Label title =
                new Label("Employee Management System");

        TextField idField =
                new TextField();
        idField.setPromptText("ID");

        TextField nameField =
                new TextField();
        nameField.setPromptText("Name");

        TextField deptField =
                new TextField();
        deptField.setPromptText("Department");

        Button addBtn =
                new Button("Add");

        Button deleteBtn =
                new Button("Delete");

        Button saveBtn =
                new Button("Save");

        Button logoutBtn =
                new Button("Logout");
        Button backBtn =
                new Button("Back");

        TableView<Employee> table =
                new TableView<>();

        TableColumn<Employee, Integer> idCol =
                new TableColumn<>("ID");

        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Employee, String> nameCol =
                new TableColumn<>("Name");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        TableColumn<Employee, String> deptCol =
                new TableColumn<>("Department");

        deptCol.setCellValueFactory(
                new PropertyValueFactory<>("department")
        );

        table.getColumns().addAll(
                idCol,
                nameCol,
                deptCol
        );

        table.setItems(employees);

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        addBtn.setOnAction(e -> {

            try {

                Employee emp =
                        new Employee(
                                Integer.parseInt(
                                        idField.getText()
                                ),
                                nameField.getText(),
                                deptField.getText(),
                                "",
                                ""
                        );

                employees.add(emp);

                idField.clear();
                nameField.clear();
                deptField.clear();

            } catch (Exception ex) {

                System.out.println(
                        "Invalid Input"
                );
            }
        });

        deleteBtn.setOnAction(e -> {

            Employee selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                employees.remove(selected);
            }
        });

        saveBtn.setOnAction(e -> {

            EmployeeFileManager
                    .saveEmployees(employees);

            System.out.println(
                    "Employees Saved"
            );
        });

        logoutBtn.setOnAction(e -> {

            LoginScreen login =
                    new LoginScreen();

            stage.setScene(
                    login.createScene(stage)
            );
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
                deptField,
                addBtn,
                deleteBtn,
                saveBtn,
                backBtn,
                logoutBtn
        );

        VBox center =
                new VBox(
                        15,
                        title,
                        form,
                        table
                );

        center.setPadding(
                new Insets(20)
        );

        root.setCenter(center);

        return new Scene(
                root,
                1000,
                700
        );
    }
}