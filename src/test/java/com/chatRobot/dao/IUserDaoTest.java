package com.chatRobot.dao;

import com.chatRobot.model.User;
import com.chatRobot.model.news;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.chatRobot.controller.util;

import java.util.Date;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private NewsDao dao;

    @Test
    public void testSelectUser() throws Exception {
       int id = 18;
        news ur = dao.selectNews(id);
        System.out.println(ur.getContent());
    }
    @Test
    public void testinsert() throws Exception {
//        User u = new User();
//        u.setPassword("456489689");
//        u.setUsername("lmk");
//        u.setEmail("sdfashg");
//        u.setRegIp("sgahtewj");
//        u.setRegTime(new Date());
//        u.setRole("agsrg");
//        u.setStatus(2);
//        dao.insertUser(u);
//        System.out.println(123);

    }
    @Test
    public void testSelectAll() throws Exception {
        int id = 18;
        news[] ur = dao.selectAll();
        for(int i=0;i<ur.length;i++)
            System.out.println(ur[i].getContent());
    }
    @Test
    public void test(){
        String s = "456";
        System.out.println(util.convert(s));
    }
}
