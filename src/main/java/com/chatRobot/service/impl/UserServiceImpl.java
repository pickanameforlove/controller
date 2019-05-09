package com.chatRobot.service.impl;

import com.chatRobot.dao.IUserDao;
import com.chatRobot.dao.NewsDao;
import com.chatRobot.model.User;
import com.chatRobot.model.news;
import com.chatRobot.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
//    private NewsDao newsDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public int insertuserr(User u){
        return this.userDao.insertUser(u);
    }
//    public news[] selectAll(){
//        return this.newsDao.selectAll();
//    }
}