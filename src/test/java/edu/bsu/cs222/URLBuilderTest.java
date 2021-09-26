package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLBuilderTest {

    @Test
    public void stringBuilderTestWithFrankZappa(){
        String userInput = "frank zappa";
        String firstHalfOfUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=";
        String userInputSectionOfUrl = URLEncoder.encode(userInput, StandardCharsets.UTF_8);
        String secondHalfOfUrl = "&redirects=1&callback=&rvprop=timestamp%7Cuser&rvlimit=30";
        String completeUrl = firstHalfOfUrl+userInputSectionOfUrl+secondHalfOfUrl;
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=frank+zappa&redirects=1&callback=&rvprop=timestamp%7Cuser&rvlimit=30",completeUrl);
    }

    @Test
    public void stringBuilderTestWithSoup(){
        String userInput = "soup";
        String firstHalfOfUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=";
        String userInputSectionOfUrl = URLEncoder.encode(userInput, StandardCharsets.UTF_8);
        String secondHalfOfUrl = "&redirects=1&callback=&rvprop=timestamp%7Cuser&rvlimit=30";
        String completeUrl = firstHalfOfUrl+userInputSectionOfUrl+secondHalfOfUrl;
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=soup&redirects=1&callback=&rvprop=timestamp%7Cuser&rvlimit=30",completeUrl);
    }
}
