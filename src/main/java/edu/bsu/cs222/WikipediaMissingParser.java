package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaMissingParser {
    public boolean parseForMissing(InputStream dataStream) throws IOException {
        try {
            JSONArray result = JsonPath.read(dataStream,"$..pages[0]");

            JSONArray redirection = JsonPath.read(result,"$..missing");

            return true;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            return false;
        }
    }
}
