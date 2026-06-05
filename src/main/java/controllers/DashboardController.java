package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        showDashboard(null);
    }

    @FXML
    private void showDashboard(javafx.event.ActionEvent event) {

        VBox root = new VBox(20);

        HBox cards = new HBox(20);

        VBox card1 = createCard("Total Employees", "25");
        VBox card2 = createCard("Present Today", "20");
        VBox card3 = createCard("Absent Today", "5");

        cards.getChildren().addAll(card1, card2, card3);

        root.getChildren().add(cards);

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void showEmployees(javafx.event.ActionEvent event) {

        VBox root = new VBox(15);

        TextField search = new TextField();
        search.setPromptText("Search Employee");

        HBox buttons = new HBox(10);

        Button add = new Button("Add");
        Button update = new Button("Update");
        Button delete = new Button("Delete");

        buttons.getChildren().addAll(add, update, delete);

        TableView<String> table = new TableView<>();

        TableColumn<String, String> idCol =
                new TableColumn<>("ID");

        TableColumn<String, String> nameCol =
                new TableColumn<>("Name");

        TableColumn<String, String> deptCol =
                new TableColumn<>("Department");

        table.getColumns().addAll(
                idCol,
                nameCol,
                deptCol
        );

        root.getChildren().addAll(
                search,
                buttons,
                table
        );

        contentArea.getChildren().setAll(root);
    }

    @FXML
    private void showAttendance(javafx.event.ActionEvent event) {

        VBox root = new VBox(15);

        Button checkIn =
                new Button("Check In");

        Button checkOut =
                new Button("Check Out");

        Button markAttendance =
                new Button("Mark Attendance");

        HBox buttons =
                new HBox(10,
                        checkIn,
                        checkOut,
                        markAttendance);

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
    private void showReports(javafx.event.ActionEvent event) {

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
    private void logout(javafx.event.ActionEvent event) {

        try {

            Parent root =
                    FXMLLoader.load(
                            getClass().getResource(
                                    "/views/Login.fxml"));

            Stage stage =
                    (Stage) contentArea
                            .getScene()
                            .getWindow();

            Scene scene =
                    new Scene(root);

            scene.getStylesheets().add(
                    getClass()
                            .getResource("/styles/style.css")
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