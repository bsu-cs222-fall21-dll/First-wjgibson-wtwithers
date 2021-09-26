package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

public class WikipediaConnector {

    private static URLConnection connectToWikipedia(String Url) throws IOException {
        try{
            URL url = new URL(Url);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "CS222FirstProject/0.1 (wtwithers@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            return connection;
        }
        catch(ConnectException connectException){
            System.out.println("Network Error");
            System.exit(2);
            return null;
        }
    }
}
