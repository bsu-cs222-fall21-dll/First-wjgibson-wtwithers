package edu.bsu.cs222;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

public class WikipediaConnector {

    public static BufferedInputStream connectToWikipedia(String Url) throws IOException {
        try{
            URL url = new URL(Url);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (wtwithers@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            return new BufferedInputStream(inputStream);
        }
        catch(ConnectException connectException){
            System.out.println("There was a network Error");
            System.exit(3);
            return null;
        }
    }
}
