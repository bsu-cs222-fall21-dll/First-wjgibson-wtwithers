package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {

    public Revision parse(InputStream testDataStream) throws IOException {
        JSONArray result = JsonPath.read(testDataStream,"$..revisions[0]");

        JSONArray user = JsonPath.read(result,"$..user");
        JSONArray timestamp = JsonPath.read(result,"$..timestamp");

        Revision revision = new Revision(user.get(0).toString(), timestamp.get(0).toString());

        return revision;
    }

}
