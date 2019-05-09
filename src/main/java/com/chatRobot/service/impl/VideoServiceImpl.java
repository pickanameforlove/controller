package com.chatRobot.service.impl;
import com.chatRobot.dao.NewsDao;
import com.chatRobot.dao.VideoDao;
import com.chatRobot.model.Video;
import com.chatRobot.model.news;
import com.chatRobot.service.NewsService;
import com.chatRobot.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "videoService")
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoDao videoDao;


    public Video[] selectAll() {
        return this.videoDao.selectAll();
    }

    @Override
    public Video[] selectBatchVideo(int ord) {
        return this.videoDao.selectBatchVideo(ord);
    }

    @Override
    public void deleteVideo(int id) {
        this.videoDao.deleteVideo(id);
    }

    @Override
    public int countVideo() {
        return this.videoDao.countVideo();
    }

    @Override
    public void update(Video v) {
        this.videoDao.update(v);
    }

    @Override
    public Video[] search(String s) {
        return this.videoDao.search(s);
    }

    @Override
    public void add(Video v) {
        this.videoDao.add(v);
    }

}
