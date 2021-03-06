package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GUIMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public TextField textField;

    @FXML
    public TextArea textArea;

    //Thank you to Zak Young and Connor Pflederer
    // for the concept of using the FXML file as the resource
    //and understanding XML as a language.
    @Override
    public void start(Stage primaryStage){

        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GuiFormat.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    @FXML
    private void getAllRevisionsWithInputField() throws IOException {
        URLBuilder urlBuilder = new URLBuilder();
        WikipediaConnector wikipediaConnector = new WikipediaConnector();
        WikipediaMissingParser missingParser = new WikipediaMissingParser();
        WikipediaRedirectParser redirectParser = new WikipediaRedirectParser();
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        RevisionFormatter formatter = new RevisionFormatter();

        String articleName = textField.getText();
        String URL = urlBuilder.BuildUrl(articleName);
        JSONArray articleJsonArray = wikipediaConnector.connectToWikipedia(URL);

        if(missingParser.parseForMissing(articleJsonArray)) {
            textArea.appendText("No Article Found");
        }

        textArea.appendText(redirectParser.parseForRedirect(articleJsonArray)+"\n");

        ArrayList<Revision> allRevisions = revisionParser.parseForRevisions(articleJsonArray);
        String formattedRevisions = formatter.format(allRevisions);
        textArea.appendText(formattedRevisions);
    }
}
