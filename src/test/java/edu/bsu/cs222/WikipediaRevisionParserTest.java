package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParseForRevisionUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision revision = parser.parse(testDataStream);
        Assertions.assertEquals("75.172.213.218",revision.getUser());
    }

    @Test
    public void testParseForRevisionTimeStamp() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision revision = parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-19T01:09:23Z",revision.getTimestamp());
    }


}
