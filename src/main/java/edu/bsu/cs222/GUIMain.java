package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GUIMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Thank you to Zak Young and Connor Pflederer
    // for the concept of using the FXML file as the resource
    @Override
    public void start(Stage primaryStage) {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GuiFormat.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*private void getAllRevisionsWithInputField() throws IOException {
        URLBuilder urlBuilder = new URLBuilder();
        WikipediaConnector wikipediaConnector = new WikipediaConnector();
        WikipediaMissingParser missingParser = new WikipediaMissingParser();
        WikipediaRedirectParser redirectParser = new WikipediaRedirectParser();
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        RevisionFormatter formatter = new RevisionFormatter();

        String articleName = inputField.getText();
        String URL = urlBuilder.BuildUrl(articleName);
        JSONArray articleJsonArray = wikipediaConnector.connectToWikipedia(URL);

        if(missingParser.parseForMissing(articleJsonArray)) {
            outputArea.appendText("No Article Found");
            System.exit(2);
        }

        outputArea.appendText(redirectParser.parseForRedirect(articleJsonArray));

        ArrayList<Revision> allRevisions = revisionParser.parseForRevisions(articleJsonArray);
        String formattedRevisions = formatter.format(allRevisions);
        outputArea.appendText(formattedRevisions);

        System.exit(0);
    }*/
}
