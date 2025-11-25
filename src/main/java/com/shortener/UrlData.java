package com.shortener;

public class UrlData {

    private int id;
    private String longUrl;
    private String shortCode;
    private int clicks;

    public UrlData(int id, String longUrl, String shortCode, int clicks) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortCode = shortCode;
        this.clicks = clicks;
    }

    public int getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public int getClicks() {
        return clicks;
    }
}

