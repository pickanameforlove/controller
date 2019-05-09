package com.chatRobot.service;
import com.chatRobot.model.NewsComment;
import com.chatRobot.model.news;
public interface NewsCommentService {
    public NewsComment[] selectAll();
    public void addComment(NewsComment c);
    public NewsComment[] selectAllById(int id);
    public NewsComment[] selectBatchNewsComment(int ord);
    public void deleteNewsComment(int id);
    public int countComment();
    public void update(NewsComment ns);
}
