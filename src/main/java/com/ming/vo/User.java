package com.ming.vo;

public class User {
    private int uid;
    private String username = null;
    private String unpassword = null;
    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUnpassword(String unpassword) {
        this.unpassword = unpassword;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getUnpassword() {
        return unpassword;
    }
}
