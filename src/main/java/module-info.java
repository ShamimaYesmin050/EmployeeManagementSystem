module EmployeeManagementSystem {

    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics;
    opens controllers to javafx.fxml;

    exports application;
}