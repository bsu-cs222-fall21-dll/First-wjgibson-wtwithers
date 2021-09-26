package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaMissingParserTest {

    @Test
    public void checkForMissingTag() throws IOException {
        WikipediaMissingParser parser = new WikipediaMissingParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testWithMissingTag.json");
        boolean missingPresent = parser.parseForMissing(testDataStream);
        Assertions.assertEquals(true,missingPresent);
    }
}
