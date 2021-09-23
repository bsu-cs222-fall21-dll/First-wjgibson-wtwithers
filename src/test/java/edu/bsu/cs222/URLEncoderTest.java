package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncoderTest {

    @Test
    public void buildUrlWithUserInput() throws UnsupportedEncodingException {
        String string = "Frank Zappa";
        String encodedString = URLEncoder.encode(string, StandardCharsets.UTF_8);
        Assertions.assertEquals("Frank+Zappa",encodedString);
    }
}

//https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=//frank%20zappa//&redirects=1&callback=&rvprop=timestamp%7Cuser&rvlimit=30
