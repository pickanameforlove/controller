package com.chatRobot.service;

import com.chatRobot.model.Jixing;

public interface JixingService {
    public Jixing[] selectAllJixing();
    public Jixing[] selectBatchJixing(int ord);
    public void deleteJixing(int id);
    public int counttuple();
    public void update(Jixing j);
    public Jixing[] search(int low);
}
