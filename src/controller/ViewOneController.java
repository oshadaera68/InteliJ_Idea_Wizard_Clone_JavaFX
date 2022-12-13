package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class ViewOneController {
    public AnchorPane scrOne;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainView.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) scrOne.getScene().getWindow();
        window.setTitle("Wizard v0.1");
        window.setScene(new Scene(load));
    }

    public void nextOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewTwo.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) scrOne.getScene().getWindow();
        window.setTitle("Wizard v0.1 - 2nd window");
        window.setScene(new Scene(load));
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        ButtonType buttonType = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonType1 = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Did you exit the wizard?", buttonType, buttonType1);
        alert.setTitle("Confirmation");
        Optional<ButtonType> close = alert.showAndWait();
        if (close.orElse(buttonType1) == buttonType) {
            Platform.exit();
            System.exit(0);
        }
    }
}
