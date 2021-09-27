package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class WikipediaRevisionParser {

    public ArrayList<Revision> parseForRevisions(JSONArray dataStream){

        JSONArray revisionArray = JsonPath.read(dataStream,"$..revisions[0:]");

        ArrayList<Revision> listOfRevisions = new ArrayList<>();

        for(int i =0 ;i<=(revisionArray.size()-1)/3;i++){
            JSONArray user = JsonPath.read(revisionArray,"$..user");
            JSONArray timestamp = JsonPath.read(revisionArray,"$..timestamp");
            Revision revision = new Revision(user.get(i).toString(),timestamp.get(i).toString());
            listOfRevisions.add(revision);
        }

        return listOfRevisions;
    }
}
