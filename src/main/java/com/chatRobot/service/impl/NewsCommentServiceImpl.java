package com.chatRobot.service.impl;
import com.chatRobot.dao.NewsCommentDao;
import com.chatRobot.dao.NewsDao;
import com.chatRobot.model.NewsComment;
import com.chatRobot.model.news;
import com.chatRobot.service.NewsCommentService;
import com.chatRobot.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "newsCommentService")
public class NewsCommentServiceImpl  implements NewsCommentService {
    @Resource
    private NewsCommentDao newsCommentDao;


    public NewsComment[] selectAll() {
        return this.newsCommentDao.selectAll();
    }

    @Override
    public void addComment(NewsComment c) {
         this.newsCommentDao.addComment(c);
    }

    @Override
    public NewsComment[] selectAllById(int id) {
        return this.newsCommentDao.selectAllById(id);
    }

    @Override
    public NewsComment[] selectBatchNewsComment(int ord) {
        return this.newsCommentDao.selectBatchNewsComment(ord);
    }

    @Override
    public void deleteNewsComment(int id) {
        this.newsCommentDao.deleteNewsComment(id);
    }

    @Override
    public int countComment() {
        return this.newsCommentDao.countComment();
    }

    @Override
    public void update(NewsComment ns) {
        this.newsCommentDao.update(ns);
    }


}
