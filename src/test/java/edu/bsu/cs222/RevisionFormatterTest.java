package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionFormatterTest {

    @Test
    public void FormatRevision() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<Revision> revisionList = parser.parseForRevisions(testDataStream);
        RevisionFormatter formatter = new RevisionFormatter();
        String formattedRevisions = formatter.format(revisionList);
        Assertions.assertEquals("2021-09-19 01:09:23 75.172.213.218\n" +
                "2021-09-19 00:54:29 75.172.213.218\n" +
                "2021-09-18 23:53:23 MusikBot II\n" +
                "2021-09-18 12:33:00 Anon423\n",formattedRevisions);

    }
}
