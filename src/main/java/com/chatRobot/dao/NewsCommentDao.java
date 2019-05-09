package com.chatRobot.dao;

import com.chatRobot.model.NewsComment;
import com.chatRobot.model.news;

public interface NewsCommentDao {
    NewsComment[] selectAll();
    void addComment(NewsComment c);
    NewsComment[] selectAllById(int id);
    NewsComment[] selectBatchNewsComment(int ord);
    void deleteNewsComment(int id);
    int countComment();
    void update(NewsComment ns);
}
