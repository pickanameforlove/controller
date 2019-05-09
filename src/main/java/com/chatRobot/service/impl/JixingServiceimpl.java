package com.chatRobot.service.impl;

import com.chatRobot.dao.JixingDao;
import com.chatRobot.model.Jixing;
import com.chatRobot.service.JixingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "jixingService")
public class JixingServiceimpl implements JixingService {
    @Resource
    private JixingDao jixingDao;

    @Override
    public Jixing[] selectAllJixing() {
        return this.jixingDao.selectAllJixing();
    }

    @Override
    public Jixing[] selectBatchJixing(int ord) {
        return this.jixingDao.selectBatchJixing(ord);
    }

    @Override
    public void deleteJixing(int id) {
        this.jixingDao.deleteJixing(id);
    }

    @Override
    public int counttuple() {
        return this.jixingDao.countTuple();
    }

    @Override
    public void update(Jixing j) {
        this.jixingDao.update(j);
    }

    @Override
    public Jixing[] search(int low) {
        return this.jixingDao.search(low);
    }

}
