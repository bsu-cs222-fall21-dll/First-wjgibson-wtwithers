package edu.bsu.cs222;


import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

public class WikipediaConnector {

    public static JSONArray connectToWikipedia(String Url) throws IOException {
        try{
            URL url = new URL(Url);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (wtwithers@bsu.edu)");

            InputStream inputStream = connection.getInputStream();
            JSONArray data = JsonPath.read(inputStream,"$..*");
            return data;

        }
        catch(ConnectException connectException){
            System.out.println("There was a network Error");
            System.exit(3);
            return null;
        }
    }
}
