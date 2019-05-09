package com.chatRobot.service;
import com.chatRobot.model.news;
public interface NewsService {
    public news selectNews(int id);
    public news[] selectAll();
    public news[] selectBatchNews(int ord);
    public void deleteNews(int id);
    public int countNews();
    public void update(news n);
    public news[] search(String s);
    public void insert(news n);
}
