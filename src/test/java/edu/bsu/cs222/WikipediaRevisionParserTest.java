package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParserTest {

    @Test
    public void testParseForRevisionUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<Revision> revisionList = parser.parse(testDataStream);
        Revision revision = revisionList.get(0);
        Assertions.assertEquals("75.172.213.218",revision.getUser());
    }

    @Test
    public void testParseForRevisionTimeStamp() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<Revision> revisionList = parser.parse(testDataStream);
        Revision revision = revisionList.get(0);
        Assertions.assertEquals("2021-09-19T01:09:23Z",revision.getTimestamp());
    }

    @Test
    public void testParseForAmountOfRevisions() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        int amountOfRevisions = JsonPath.read(testDataStream,"$..revisions.length()");
        Assertions.assertEquals(4,amountOfRevisions);
    }



}
