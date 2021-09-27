package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;



import java.io.IOException;
import java.io.InputStream;

public class WikipediaMissingParser {
    public boolean parseForMissing(JSONArray dataStream) throws IOException {

        try {

            JSONArray result = JsonPath.read(dataStream,"$..pages");

            JSONArray redirection = JsonPath.read(result,"$..missing");
            String missingValue = redirection.get(0).toString();

            if(missingValue.equals("")){
                return true;
            }
            else{
                return false;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){

            return false;
        }
    }
}
