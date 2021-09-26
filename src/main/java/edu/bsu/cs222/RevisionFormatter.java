package edu.bsu.cs222;

import java.util.ArrayList;

public class RevisionFormatter {

    public String format(ArrayList<Revision> revisionList) {
        String allRevisions = "";
        for (int i = 0;i <= revisionList.size()-1;i++){
            Revision revision = revisionList.get(i);
            allRevisions += revision.getTimestamp();
            allRevisions += revision.getUser();
        }
        return allRevisions;
    }
}
