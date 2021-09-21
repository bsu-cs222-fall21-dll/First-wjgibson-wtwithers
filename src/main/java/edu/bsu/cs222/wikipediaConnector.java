package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class wikipediaConnector {
    private static URLConnection connectToWikipedia() throws IOException {
        URL url = new URL(
                "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=frank%20zappa&redirects=");
        // %20 = space so frank%20zappa = "frank zappa"
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (wtwithers@bsu.edu)");
        connection.connect();
        return connection;
    }
}
