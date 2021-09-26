package edu.bsu.cs222;

import java.util.ArrayList;

public class RevisionFormatter {

    public String format(ArrayList<Revision> revisionList) {
        String allRevisions = "";
        for (int i = 0;i <= revisionList.size()-1;i++){
            Revision revision = revisionList.get(i);
            String user = revision.getUser();
            String timestamp = revision.getTimestamp();

            String dateOfTimestamp = timestamp.substring(0,timestamp.indexOf("T"));
            String timeOfTimestamp = timestamp.substring(timestamp.indexOf("T")+1,timestamp.indexOf("Z"));
            String formattedRevision = String.format("%s %s %s\n",dateOfTimestamp,timeOfTimestamp,user);

            allRevisions += formattedRevision;
        }
        return allRevisions;
    }
}
