package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML private Button buttonYoutube;
    @FXML private Button buttonTwitch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonYoutube.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonAction(event);
            }
        });

        buttonTwitch.setOnAction(event -> handleButtonAction(event));


    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Pane newPane;
            Scene newScene;
            Stage newStage;

            Button tmpButton = (Button) event.getSource();
            switch (tmpButton.getId()) {
                case "buttonYoutube":
                    newPane = FXMLLoader.load(getClass().getResource("youtube.fxml"));
                    newScene = new Scene(newPane);
                    newStage = new Stage();
                    newStage.setScene(newScene);
                    newStage.setTitle("DDOKDDOK Chatbot - Youtube");
                    newStage.show();
                    break;
                case "buttonTwitch" :
                    newPane = FXMLLoader.load(getClass().getResource("twitch.fxml"));
                    newScene = new Scene(newPane);
                    newStage = new Stage();
                    newStage.setScene(newScene);
                    newStage.setTitle("DDOKDDOK Chatbot - Twitch");
                    newStage.show();

                    break;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
