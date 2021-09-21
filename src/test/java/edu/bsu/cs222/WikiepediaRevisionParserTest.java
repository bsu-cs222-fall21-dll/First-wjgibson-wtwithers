package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class WikiepediaRevisionParserTest {

    @Test
    public void testParse(){
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testResource.json");
        String timeStamp = parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-19T01:09:23Z",timeStamp);
    }
}
