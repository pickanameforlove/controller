package com.chatRobot.dao;

import com.chatRobot.model.Jixing;

public interface JixingDao {
    Jixing[] selectAllJixing();
    Jixing[] selectBatchJixing(int ord);
    void deleteJixing(int id);
    int countTuple();
    void update(Jixing j);
    Jixing[] search(int low);
}
