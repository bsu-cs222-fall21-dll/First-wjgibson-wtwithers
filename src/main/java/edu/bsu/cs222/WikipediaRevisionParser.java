package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {

    public String parse(InputStream testDataStream) throws IOException {
        JSONArray revision = (JSONArray) JsonPath.read(testDataStream,"$..revisions[0]");

        JSONArray user = (JSONArray) JsonPath.read(revision,"$..user");
        JSONArray timestamp = (JSONArray) JsonPath.read(revision,"$..timestamp");

        return revision.get(0).toString();
    }

}
