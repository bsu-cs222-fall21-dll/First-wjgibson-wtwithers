package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;

public class WikipediaMissingParserTest {

    @Test
    public void checkForMissingTag() throws IOException {
        WikipediaMissingParser parser = new WikipediaMissingParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testWithMissingTag.json");
        JSONArray data = JsonPath.read(testDataStream,"$..*");
        boolean missingPresent = parser.parseForMissing(data);
        Assertions.assertTrue(missingPresent);
    }
    @Test
    public void checkForNoMissingTag() throws IOException {
        WikipediaMissingParser parser = new WikipediaMissingParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray data = JsonPath.read(testDataStream,"$..*");
        boolean missingPresent = parser.parseForMissing(data);
        Assertions.assertFalse(missingPresent);
    }
}
