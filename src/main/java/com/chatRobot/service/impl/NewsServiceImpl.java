package com.chatRobot.service.impl;
import com.chatRobot.dao.NewsDao;
import com.chatRobot.model.news;
import com.chatRobot.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;
    public news selectNews(int id){
        return this.newsDao.selectNews(id);
    }


    public news[] selectAll() {
        return this.newsDao.selectAll();
    }

    @Override
    public news[] selectBatchNews(int ord) {
        return this.newsDao.selectBatchNews(ord);
    }

    @Override
    public void deleteNews(int id) {
        this.newsDao.deleteNews(id);
    }

    @Override
    public int countNews() {
        return this.newsDao.countNews();
    }

    @Override
    public void update(news n) {
        this.newsDao.update(n);
    }

    @Override
    public news[] search(String s) {
        return this.newsDao.search(s);
    }

    @Override
    public void insert(news n) {
        this.newsDao.insert(n);
    }

}
