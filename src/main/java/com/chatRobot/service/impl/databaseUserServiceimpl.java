package com.chatRobot.service.impl;

import com.chatRobot.dao.IUserDao;
import com.chatRobot.dao.NewsDao;
import com.chatRobot.dao.databaseUserDao;
import com.chatRobot.model.User;
import com.chatRobot.model.databaseUser;
import com.chatRobot.model.news;
import com.chatRobot.service.IUserService;
import com.chatRobot.service.databaseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("databaseUserService")
public class databaseUserServiceimpl implements databaseUserService {

    @Resource
    private databaseUserDao databaseUserDao;
    @Override
    public databaseUser selectUser(int id) {
        return this.databaseUserDao.selectUser(id);
    }

    @Override
    public int findUser(databaseUser u) {
        return this.databaseUserDao.findUser(u);
    }

    @Override
    public databaseUser[] getAll() {
        return this.databaseUserDao.getAll();
    }

    @Override
    public int countdatabaseUser() {
        return this.databaseUserDao.countdatabaseUser();
    }

    @Override
    public void update(databaseUser u) {
        this.databaseUserDao.update(u);
    }

    @Override
    public void add(databaseUser u) {
        this.databaseUserDao.add(u);
    }
}
