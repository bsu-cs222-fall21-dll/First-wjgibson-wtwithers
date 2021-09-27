package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaMissingParser {
    public boolean parseForMissing(JSONArray dataStream)  {

        try {

            JSONArray pagesDataArray = JsonPath.read(dataStream,"$..pages");

            JSONArray redirectionValue = JsonPath.read(pagesDataArray,"$..missing");
            String missingValue = redirectionValue.get(0).toString();

            return missingValue.equals("");
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){

            return false;
        }
    }
}
