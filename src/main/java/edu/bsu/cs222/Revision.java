package edu.bsu.cs222;

public class Revision {
    private String user;//wrong data type?
    private String timestamp;

    public Revision(String user, String timestamp) {
        this.user = user;
        this.timestamp = timestamp;
    }
}