package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRedirectParser {

    public String parseForRedirect(JSONArray dataStream){

        try {

            JSONArray redirectData = JsonPath.read(dataStream,"$..redirects");

            JSONArray redirectionTitle = JsonPath.read(redirectData,"$..to");

            return "Redirected to "+redirectionTitle.get(0).toString();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){

            return "";
        }
    }
}
