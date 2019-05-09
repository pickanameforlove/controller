package com.chatRobot.model;

public class databaseUser {
    private int id;
    private String account;
    private String password;

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    private boolean isAdmin;
}
