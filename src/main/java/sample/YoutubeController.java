package sample;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class YoutubeController implements Initializable {
    //3Buttons, TableView initialize.
    @FXML
    private Button keywords;
    @FXML
    private Button urls;
    @FXML
    private Button streamers;
    @FXML
    private TableView<tempDSProperty> youtubeTable;
    @FXML
    private TableColumn<tempDSProperty, String> userID;
    @FXML
    private TableColumn<tempDSProperty, String> nickName;
    @FXML
    private TableColumn<tempDSProperty, String> chat;
    @FXML
    private TableColumn<tempDSProperty, String> status;

    //temp initialize for show test
    tempDS sangheon = new tempDS("comnamu18", "킹잘빛상헌", "병신들 ㅉㅉ");

    tempDS jewoong = new tempDS("jwoonge", "쩨웅", "개노답이네 ㅅㅂ");


    //initialize table contents, button actions.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sangheon.setIsBadword(true);
        jewoong.setIsBadword(true);

        ObservableList<tempDSProperty> myList = FXCollections.observableArrayList(
            new tempDSProperty("jjiho", "노래하는찌호", "hello",false ,true),
            new tempDSProperty(sangheon),
            new tempDSProperty(jewoong)
        );

        userID.setCellValueFactory(cellData -> cellData.getValue().getUserID());
        nickName.setCellValueFactory(cellData -> cellData.getValue().getUserNickName());
        chat.setCellValueFactory(cellData -> cellData.getValue().getChatText());
        status.setCellValueFactory(cellData -> setStatus(cellData.getValue().getIsBadword(), cellData.getValue().getIsNamed()));
        youtubeTable.setItems(myList);

        //call each corresponding window that will be shown for clicking button
        keywords.setOnAction(event -> keywordsWindow());
        urls.setOnAction(event -> urlsWindow());
        streamers.setOnAction(event->streamersWindow());

        youtubeTable.setOnMouseClicked(event -> {
            tempDSProperty selected = youtubeTable.getSelectionModel().getSelectedItem();
            banUser(selected);
        });

    }

    /*
    public void addList(tempDS element) {
        youtubeTable.getItems().add(new tempDSProperty(element);
    }
    */

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
    public void banUser(tempDSProperty selected) {
        if(false) {
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("inputSuccess.fxml"));
                Scene newScene = new Scene(newPane);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.setTitle(selected.getUserNickName().getValue() + " was banned");
                newStage.show();
                youtubeTable.getSelectionModel().clearSelection();
                youtubeTable.getItems().remove(selected);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("inputFail.fxml"));
                Scene newScene = new Scene(newPane);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.setTitle("Ban " + selected.getUserNickName().getValue() + " failed");
                newStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public StringProperty setStatus(BooleanProperty isBadword, BooleanProperty isNamed) {
        if(isBadword.getValue() == true) {
            return new SimpleStringProperty("욕설");
        }
        else if(isNamed.getValue() == true) {
            return new SimpleStringProperty("스트리머방문");
        }
        else
            return new SimpleStringProperty("아무튼 이상함");
    }
}