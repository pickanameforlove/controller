package com.chatRobot.service;
import com.chatRobot.model.Video;
public interface VideoService {
    public Video[] selectAll();
    public Video[] selectBatchVideo(int ord);
    public void deleteVideo(int id);
    public int countVideo();
    public void update(Video v);
    public Video[] search(String s);
    public void add(Video v);
}
