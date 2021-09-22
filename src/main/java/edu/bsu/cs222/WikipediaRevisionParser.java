package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {

    public Revision parse(InputStream testDataStream) throws IOException {
        JSONArray user = (JSONArray) JsonPath.read(testDataStream,"$..user");
        String field1 = user.get(0).toString();

        JSONArray timestamp = (JSONArray) JsonPath.read(testDataStream,"$..timestamp");
        String field2 = timestamp.get(0).toString();

        Revision revision = new Revision(field1,field2);
        return revision;


    }
}
