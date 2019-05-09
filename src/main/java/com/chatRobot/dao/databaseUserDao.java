package com.chatRobot.dao;

import com.chatRobot.model.databaseUser;

public interface databaseUserDao {

    databaseUser selectUser(int id);
    int findUser(databaseUser u);
    databaseUser[] getAll();
    int countdatabaseUser();
    void update(databaseUser u);
    void add(databaseUser u);
}
