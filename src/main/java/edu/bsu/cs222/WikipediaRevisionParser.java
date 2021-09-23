package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {

    public ArrayList<Revision> parse(InputStream dataStream) throws IOException {

        JSONArray result = JsonPath.read(dataStream,"$..revisions");

        int numberOfRevisions = JsonPath.read(dataStream,"$..revisions.length()");

        ArrayList<Revision> listOfRevisions = new ArrayList<>();

        for(int i =0 ;i<=numberOfRevisions-1;i++){
            JSONArray user = JsonPath.read(result,"$..user");
            JSONArray timestamp = JsonPath.read(result,"$..timestamp");
            Revision revision = new Revision(user.get(i).toString(), timestamp.get(i).toString());

            listOfRevisions.add(revision);
        }

        return listOfRevisions;
    }
}
