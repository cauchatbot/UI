package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputFailController implements Initializable {
    @FXML private Button ok;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ok.setOnAction(event -> okCliked());
    }

    private void okCliked() {
        Stage oldStage = (Stage) ok.getScene().getWindow();
        oldStage.close();
    }
}

