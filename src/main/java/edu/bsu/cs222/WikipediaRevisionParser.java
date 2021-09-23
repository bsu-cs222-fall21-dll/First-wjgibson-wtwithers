package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {

    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream,"$..revisions[0]");
        return result.get(0).toString();
    }

}
