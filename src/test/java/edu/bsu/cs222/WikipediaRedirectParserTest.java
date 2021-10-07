package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WikipediaRedirectParserTest {

    @Test
    public void checkIfRevisionContainsRedirect() throws IOException {
        WikipediaRedirectParser parser = new WikipediaRedirectParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray data = JsonPath.read(testDataStream,"$..*");
        String redirect = parser.parseForRedirect(data);
        Assertions.assertEquals("Redirected to Frank Zappa",redirect);
    }

    @Test
    public void checkIfRevisionContainsNoRedirect() throws IOException {
        WikipediaRedirectParser parser = new WikipediaRedirectParser();
        BufferedInputStream testDataStream = (BufferedInputStream) Thread.currentThread().getContextClassLoader().getResourceAsStream("testWithoutRedirect.json");
        JSONArray data = JsonPath.read(testDataStream,"$..*");
        String redirect = parser.parseForRedirect(data);
        Assertions.assertEquals("",redirect);
    }
}
