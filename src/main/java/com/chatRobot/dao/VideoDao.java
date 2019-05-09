package com.chatRobot.dao;

import com.chatRobot.model.Video;


public interface VideoDao {
    Video[] selectAll();
    Video[] selectBatchVideo(int ord);
    void deleteVideo(int id);
    int countVideo();
    void update(Video v);
    Video[] search(String s);
    void add(Video v);
}
