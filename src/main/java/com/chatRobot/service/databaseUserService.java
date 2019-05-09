package com.chatRobot.service;


import com.chatRobot.model.databaseUser;

public interface databaseUserService {

    public databaseUser selectUser(int id);
    public int findUser(databaseUser u);
    public databaseUser[] getAll();
    public int countdatabaseUser();
    public void update(databaseUser u);
    public void add(databaseUser u);

}
