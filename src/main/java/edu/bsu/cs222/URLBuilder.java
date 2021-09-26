package edu.bsu.cs222;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLBuilder {

    public String BuildUrl(String userInput){
        String firstHalfOfUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=";
        String userInputSectionOfUrl = URLEncoder.encode(userInput, StandardCharsets.UTF_8);
        String secondHalfOfUrl = "&redirects=1&rvprop=timestamp%7Cuser&rvlimit=30";
        String completeUrl = firstHalfOfUrl+userInputSectionOfUrl+secondHalfOfUrl;

        return completeUrl;
    }
}
