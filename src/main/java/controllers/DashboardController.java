package controllers;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Employee;

public class DashboardController {

    private ObservableList<Employee> employees =
            FXCollections.observableArrayList();

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {

        employees.add(new Employee(
                1,
                "Shamima",
                "CSE",
                "shamima@gmail.com",
                "01711111111"
        ));

        employees.add(new Employee(
                2,
                "Yesmin",
                "CSE",
                "yesmin@gmail.com",
                "01822222222"
        ));

        employees.add(new Employee(
                3,
                "Jarin",
                "CSE",
                "jarin@gmail.com",
                "01933333333"
        ));

        employees.add(new Employee(
                4,
                "Nishat",
                "IT",
                "nishat@gmail.com",
                "01711111112"
        ));

        employees.add(new Employee(
                5,
                "Medha",
                "English",
                "medha@gmail.com",
                "01822222221"
        ));

        employees.add(new Employee(
                6,
                "Mouno",
                "EEE",
                "mouno@gmail.com",
                "01933333331"
        ));

        System.out.println(
                "Employees Loaded: "
                        + employees.size()
        );

        showDashboard(null);
    }

    @FXML
    private void showDashboard(ActionEvent event) {

        VBox root = new VBox(20);

        HBox cards = new HBox(20);

        VBox card1 = createCard(
                "Total Employees",
                String.valueOf(employees.size())
        );

        VBox card2 = createCard(
                "Present Today",
                "20"
        );

        VBox card3 = createCard(
                "Absent Today",
                "5"
        );

        cards.getChildren().addAll(
                card1,
                card2,
                card3
        );

        root.getChildren().add(cards);

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void showEmployees(ActionEvent event) {

        VBox root = new VBox(15);

        TextField searchField = new TextField();
        searchField.setPromptText("Search Employee");

        TableView<Employee> employeeTable = new TableView<>();

        employeeTable.setColumnResizePolicy(
        TableView.CONSTRAINED_RESIZE_POLICY
        );

        employeeTable.setPrefHeight(300);

        TableColumn<Employee, Number> idColumn =
        new TableColumn<>("ID");
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Employee, String> nameColumn =
                new TableColumn<>("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        TableColumn<Employee, String> deptColumn =
                new TableColumn<>("Department");
        deptColumn.setCellValueFactory(
                new PropertyValueFactory<>("department")
        );

        TableColumn<Employee, String> emailColumn =
                new TableColumn<>("Email");
        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        TableColumn<Employee, String> phoneColumn =
                new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phone")
        );

        employeeTable.getColumns().addAll(
                idColumn,
                nameColumn,
                deptColumn,
                emailColumn,
                phoneColumn
        );
        FilteredList<Employee> filtered =
        new FilteredList<>(employees, p -> true);

searchField.textProperty().addListener(
        (obs, oldVal, newVal) -> {

            System.out.println(
                    "Searching: " + newVal
            );

            filtered.setPredicate(employee -> {

                if (newVal == null ||
                        newVal.trim().isEmpty()) {
                    return true;
                }

                String keyword =
                        newVal.toLowerCase();

                return String.valueOf(employee.getId())
                                .contains(keyword)

                        ||

                        employee.getName()
                                .toLowerCase()
                                .contains(keyword)

                        ||

                        employee.getDepartment()
                                .toLowerCase()
                                .contains(keyword)

                        ||

                        employee.getEmail()
                                .toLowerCase()
                                .contains(keyword)

                        ||

                        employee.getPhone()
                                .toLowerCase()
                                .contains(keyword);
            });
        });

employeeTable.setItems(filtered);
        System.out.println(
        "Employee Count = "
                + employees.size()
);
        employeeTable.setItems(filtered);

        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField deptField = new TextField();
        deptField.setPromptText("Department");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");

        employeeTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldEmp, selectedEmp) -> {

                            if (selectedEmp != null) {

                                idField.setText(
                                        String.valueOf(
                                                selectedEmp.getId()
                                        )
                                );

                                nameField.setText(
                                        selectedEmp.getName()
                                );

                                deptField.setText(
                                        selectedEmp.getDepartment()
                                );

                                emailField.setText(
                                        selectedEmp.getEmail()
                                );

                                phoneField.setText(
                                        selectedEmp.getPhone()
                                );
                            }
                        });

        Button addBtn = new Button("Add");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        addBtn.setOnAction(e -> {

    // Empty field validation
    if (
            idField.getText().isEmpty() ||
            nameField.getText().isEmpty() ||
            deptField.getText().isEmpty() ||
            emailField.getText().isEmpty() ||
            phoneField.getText().isEmpty()
    ) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields are required!");
            alert.showAndWait();
             return;
    }

    try {

     int id = Integer.parseInt(
        idField.getText()
);

if (id <= 0) {

    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Invalid ID");
    alert.setHeaderText(null);
    alert.setContentText("ID must be greater than 0!");
    alert.showAndWait();

    return;
}

        // Duplicate ID validation
        boolean exists =
                employees.stream()
                        .anyMatch(emp ->
                                emp.getId() == id
                        );

        if (exists) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate ID");
            alert.setHeaderText(null);
            alert.setContentText("Employee ID already exists!");
            alert.showAndWait();

        return;
        }

        Employee employee =
                new Employee(
                        id,
                        nameField.getText(),
                        deptField.getText(),
                        emailField.getText(),
                        phoneField.getText()
                );

        employees.add(employee);

        idField.clear();
        nameField.clear();
        deptField.clear();
        emailField.clear();
        phoneField.clear();

    } catch (NumberFormatException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid ID");
            alert.setHeaderText(null);
            alert.setContentText("ID must be a number!");
            alert.showAndWait();
    }
});

       updateBtn.setOnAction(e -> {

    Employee selected =
            employeeTable.getSelectionModel()
                    .getSelectedItem();

    if (selected == null) {

        Alert alert =
                new Alert(Alert.AlertType.WARNING);

        alert.setTitle("No Selection");
        alert.setHeaderText(null);
        alert.setContentText(
                "Please select an employee first."
        );

        alert.showAndWait();

        return;
    }

    if (
            nameField.getText().isEmpty() ||
            deptField.getText().isEmpty() ||
            emailField.getText().isEmpty() ||
            phoneField.getText().isEmpty()
    ) {

        Alert alert =
                new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(
                "All fields are required!"
        );

        alert.showAndWait();

        return;
    }

    selected.setName(
            nameField.getText()
    );

    selected.setDepartment(
            deptField.getText()
    );

    selected.setEmail(
            emailField.getText()
    );

    selected.setPhone(
            phoneField.getText()
    );

    employeeTable.refresh();
        employeeTable.getSelectionModel().clearSelection();
        idField.clear();
        nameField.clear();
        deptField.clear();
        emailField.clear();
        phoneField.clear();

    Alert alert =
            new Alert(Alert.AlertType.INFORMATION);

    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText(
            "Employee updated successfully!"
    );

    alert.showAndWait();
});

        deleteBtn.setOnAction(e -> {

    Employee selected =
            employeeTable.getSelectionModel()
                    .getSelectedItem();

    if (selected == null) {

        Alert alert =
                new Alert(Alert.AlertType.WARNING);

        alert.setTitle("No Selection");
        alert.setHeaderText(null);
        alert.setContentText(
                "Please select an employee first."
        );

        alert.showAndWait();

        return;
    }

    Alert confirm =
            new Alert(Alert.AlertType.CONFIRMATION);

    confirm.setTitle("Confirm Delete");
    confirm.setHeaderText(null);
    confirm.setContentText(
            "Are you sure you want to delete this employee?"
    );

    Optional<ButtonType> result =
            confirm.showAndWait();

    if (result.isEmpty() ||
            result.get() != ButtonType.OK) {

        return;
    }

    employees.remove(selected);

    employeeTable.getSelectionModel()
            .clearSelection();

    idField.clear();
    nameField.clear();
    deptField.clear();
    emailField.clear();
    phoneField.clear();

    Alert alert =
            new Alert(Alert.AlertType.INFORMATION);

    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText(
            "Employee deleted successfully!"
    );

    alert.showAndWait();
});


        HBox buttonBox = new HBox(
                10,
                addBtn,
                updateBtn,
                deleteBtn
        );

        VBox form = new VBox(
                10,
                idField,
                nameField,
                deptField,
                emailField,
                phoneField,
                buttonBox
        );

        root.getChildren().addAll(
                searchField,
                employeeTable,
                form
        );

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void showAttendance(ActionEvent event) {

        VBox root = new VBox(15);

        Button checkIn =
                new Button("Check In");

        Button checkOut =
                new Button("Check Out");

        Button markAttendance =
                new Button("Mark Attendance");

        HBox buttons = new HBox(
                10,
                checkIn,
                checkOut,
                markAttendance
        );

        TableView<String> table =
                new TableView<>();

        TableColumn<String, String> idCol =
                new TableColumn<>("ID");

        TableColumn<String, String> nameCol =
                new TableColumn<>("Name");

        TableColumn<String, String> statusCol =
                new TableColumn<>("Status");

        table.getColumns().addAll(
                idCol,
                nameCol,
                statusCol
        );

        root.getChildren().addAll(
                buttons,
                table
        );

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void showReports(ActionEvent event) {

        VBox root = new VBox(15);

        Button empReport =
                new Button("Employee Report");

        Button attendanceReport =
                new Button("Attendance Report");

        TextArea preview =
                new TextArea();

        preview.setPromptText(
                "Report Preview Area"
        );

        root.getChildren().addAll(
                empReport,
                attendanceReport,
                preview
        );

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void logout(ActionEvent event) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/views/Login.fxml"
                            )
                    );

            Parent root = loader.load();

            Stage stage =
                    (Stage) contentArea
                            .getScene()
                            .getWindow();

            Scene scene =
                    new Scene(root);

            scene.getStylesheets().add(
                    getClass()
                            .getResource(
                                    "/styles/style.css"
                            )
                            .toExternalForm()
            );

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private VBox createCard(
            String title,
            String value) {

        Label titleLabel =
                new Label(title);

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size:24;"
        );

        VBox card =
                new VBox(
                        10,
                        titleLabel,
                        valueLabel
                );

        card.getStyleClass()
                .add("dashboard-card");

        card.setPrefWidth(180);

        return card;
    }
}