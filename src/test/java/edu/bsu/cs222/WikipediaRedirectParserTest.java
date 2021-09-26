package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRedirectParserTest {

    @Test
    public void checkIfRevisionContainsRedirect() throws IOException {
        WikipediaRedirectParser parser = new WikipediaRedirectParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String redirect = parser.parse(testDataStream);
        Assertions.assertEquals("Redirected to Frank Zappa",redirect);
    }

    @Test
    public void checkIfRevisionContainsNoRedirect() throws IOException {
        WikipediaRedirectParser parser = new WikipediaRedirectParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testWithoutRedirect.json");
        String redirect = parser.parse(testDataStream);
        Assertions.assertEquals(null,redirect);
    }
}
