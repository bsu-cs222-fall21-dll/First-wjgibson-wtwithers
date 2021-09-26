package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRedirectParser {

    public String parseForRedirect(InputStream dataStream) throws IOException {
        try {
            JSONArray result = JsonPath.read(dataStream,"$..redirects");

            JSONArray redirection = JsonPath.read(result,"$..to");
            String redirectionMessage = "Redirected to "+redirection.get(0).toString();

            return redirectionMessage;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            return null;
        }
    }
}
