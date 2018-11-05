package com.imooc.entity;

public class User {
    private String SessionIdString;
    private String ipString;
    private String firstTimeString;

    public String getSessionIdString() {
        return SessionIdString;
    }

    public void setSessionIdString(String sessionIdString) {
        SessionIdString = sessionIdString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getFirstTimeString() {
        return firstTimeString;
    }

    public void setFirstTimeString(String firstTimeString) {
        this.firstTimeString = firstTimeString;
    }
}
