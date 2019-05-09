package com.chatRobot.dao;

import com.chatRobot.model.news;

public interface NewsDao {
    news selectNews(int id);
    news[] selectAll();
    news[] selectBatchNews(int ord);
    void deleteNews(int id);
    int countNews();
    void update(news n);
    news[] search(String s);
    void insert(news n);

}
