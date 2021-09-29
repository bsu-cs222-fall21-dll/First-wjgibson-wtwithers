package edu.bsu.cs222;


import net.minidev.json.JSONArray;

import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        UserInput userinput = new UserInput();
        URLBuilder urlBuilder = new URLBuilder();
        WikipediaConnector wikipediaConnector = new WikipediaConnector();
        WikipediaMissingParser missingParser = new WikipediaMissingParser();
        WikipediaRedirectParser redirectParser = new WikipediaRedirectParser();
        WikipediaRevisionParser revisionParser = new WikipediaRevisionParser();
        RevisionFormatter formatter = new RevisionFormatter();

        String articleName = userinput.getUserInput();
        String URL = urlBuilder.BuildUrl(articleName);
        JSONArray articleJsonArray = wikipediaConnector.connectToWikipedia(URL);

        if(missingParser.parseForMissing(articleJsonArray)){
            System.err.println("No Article Found");
            System.exit(2);
        }

        System.out.println(redirectParser.parseForRedirect(articleJsonArray));

        ArrayList<Revision> allRevisions = revisionParser.parseForRevisions(articleJsonArray);
        System.out.println(formatter.format(allRevisions));
        System.exit(0);
    }
}
