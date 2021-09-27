package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncoderTest {

    @Test
    public void buildUrlWithUserInput(){
        String string = "Frank Zappa";
        String encodedString = URLEncoder.encode(string, StandardCharsets.UTF_8);
        Assertions.assertEquals("Frank+Zappa",encodedString);
    }
}