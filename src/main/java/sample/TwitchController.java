package sample;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class TwitchController implements Initializable {
    //3Buttons, TableView initialize.
    @FXML
    private Button keywords;
    @FXML
    private Button urls;
    @FXML
    private Button streamers;
    @FXML
    private TableView<tempDSProperty> twitchTable;
    @FXML
    private TableColumn<tempDSProperty, String> userID;
    @FXML
    private TableColumn<tempDSProperty, String> nickName;
    @FXML
    private TableColumn<tempDSProperty, String> chat;

    //temp initialize for show test
    tempDS seongmin = new tempDS("shieldnet", "ATEZ", "시발");
    ObservableList<tempDSProperty> myList = FXCollections.observableArrayList(
            new tempDSProperty("kwxyk", "Reichidad", "Sex!!!!!!!!!", true),
            new tempDSProperty(seongmin)
    );

    //initialize table contents, button actions.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userID.setCellValueFactory(cellData -> cellData.getValue().getUserID());
        nickName.setCellValueFactory(cellData -> cellData.getValue().getUserNickName());
        chat.setCellValueFactory(cellData -> cellData.getValue().getChatText());
        twitchTable.setItems(myList);

        //call each corresponding window that will be shown for clicking button
        keywords.setOnAction(event -> keywordsWindow());
        urls.setOnAction(event -> urlsWindow());
        streamers.setOnAction(event->streamersWindow());

    }

    // show keywords window.
    public void keywordsWindow(){
        try {
            Desktop.getDesktop().edit(new File("C:\\Users\\김영현\\IdeaProjects\\UI02\\src\\main\\java\\sample\\keywords.txt"));
            Pane newPane = FXMLLoader.load(getClass().getResource("keywords.fxml"));
            Scene newScene = new Scene(newPane);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("DDOKDDOK Chatbot keywords");
            newStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    // show urls window.
    public void urlsWindow(){
        try {
            Desktop.getDesktop().edit(new File("C:\\Users\\김영현\\IdeaProjects\\UI02\\src\\main\\java\\sample\\urls.txt"));
            Pane newPane = FXMLLoader.load(getClass().getResource("urls.fxml"));
            Scene newScene = new Scene(newPane);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("DDOKDDOK Chatbot urls");
            newStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    //show streamers window.
    public void streamersWindow(){
        try {
            Desktop.getDesktop().edit(new File("C:\\Users\\김영현\\IdeaProjects\\UI02\\src\\main\\java\\sample\\streamers.txt"));
            Pane newPane = FXMLLoader.load(getClass().getResource("streamers.fxml"));
            Scene newScene = new Scene(newPane);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("DDOKDDOK Chatbot streamers");
            newStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}
