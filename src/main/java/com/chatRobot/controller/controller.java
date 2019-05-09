package com.chatRobot.controller;

import javax.servlet.http.HttpServletRequest;

import com.chatRobot.model.*;
import com.chatRobot.service.*;
import com.chatRobot.service.impl.NewsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import com.chatRobot.controller.util;

@Controller
@CrossOrigin(origins ="*" )
@RequestMapping("/user")
public class controller {

    @Resource
    private IUserService userService;
    @Resource
    private NewsService newsService;
    @Resource
    private VideoService videoService;
    @Resource
    private NewsCommentService newsCommentService;
    @Resource
    private JixingService jixingService;
    @Resource
    private databaseUserService databaseUserService;
//    private NewsServiceImpl newsService;
    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }
    @RequestMapping("/UserInsert")
    public void insertuserr(HttpServletRequest request, HttpServletResponse response) throws  Exception{
//        User u = new User();
//        u.setPassword("4564889");
//        u.setUsername("lm");
//        u.setEmail("sdfa");
//        u.setRegIp("sgah");
//        u.setRegTime(new Date());
//        u.setRole("ags");
//        u.setStatus(2);
//        this.userService.insertuserr(u);
    }
    @RequestMapping("/getAllNews")
    public void selectall(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        news[] a = this.newsService.selectAll();
//        System.out.println(a.length);


//        System.out.println("ddddddd");
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/getAllVideo")
    public void selectallV(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        Video[] a = this.videoService.selectAll();
//        System.out.println(a.length);


//        System.out.println("ddddddd");
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/getNewsById/{id}")
    public void selectNewsById(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
//        System.out.println("id = " + id );
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        news n = this.newsService.selectNews(id);
        response.getWriter().write(mapper.writeValueAsString(n));
        System.out.println(n.getContent());
        response.getWriter().close();
    }
    @RequestMapping("/getNewsComments")
    public void selectNewsComment(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        NewsComment[] a = this.newsCommentService.selectAll();
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping(value="/postComment",method= RequestMethod.POST)
    public void addComment(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String userImg = request.getParameter("userImg");
        String nickName = request.getParameter("userNickname");
        String content = request.getParameter("content");
        Date date = new Date();
        NewsComment c = new NewsComment();
        c.setId(id);
        c.setContent(content);
        c.setTime(date);
        c.setUserImg(userImg);
        c.setUserNickname(nickName);
        this.newsCommentService.addComment(c);


    }
    @RequestMapping("/getNewsCommentsById/{id}")
    public void selectNewsComment(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        NewsComment[] a = this.newsCommentService.selectAllById(id);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/getAllJixing")
    public void selectAllJixing(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        Jixing[] a = this.jixingService.selectAllJixing();
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/getBatchNews")
    public void selectBatchN(int ord,HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        news[] a = this.newsService.selectBatchNews(ord);

        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/deleteNews")
    public void deleteNews(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        this.newsService.deleteNews(id);
    }

    @RequestMapping("/getBatchNewsComment")
    public void selectBatchNC(int ord,HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        NewsComment[] a = this.newsCommentService.selectBatchNewsComment(ord);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/deleteNewsComment")
    public void deleteNewsComment(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        this.newsCommentService.deleteNewsComment(id);
    }

    @RequestMapping("/getBatchVideo")
    public void selectBatchV(int ord,HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Video[] a = this.videoService.selectBatchVideo(ord);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/deleteVideo")
    public void deleteVideo(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        this.videoService.deleteVideo(id);
    }
    @RequestMapping("/getBatchJixing")
    public void selectBatchJ(int ord,HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Jixing[] a = this.jixingService.selectBatchJixing(ord);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/deleteJixing")
    public void deleteJixing(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        this.jixingService.deleteJixing(id);
    }
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public void adminLogin(@RequestParam("name") String name,@RequestParam("pass") String password, HttpServletRequest request, HttpServletResponse response)throws Exception{
//        System.out.println(name);
//        System.out.println(password);
        databaseUser user = new databaseUser();
        user.setAccount(name);
        user.setPassword(password);
        int a = this.databaseUserService.findUser(user);
        System.out.println(a);
        databaseUser user2 = this.databaseUserService.selectUser(a);
        if(user2.getAccount().equals(name)&& user2.getPassword().equals(password)){
            response.getWriter().write(1);
            response.getWriter().close();
        }else{
            response.getWriter().write(0);
            response.getWriter().close();
        }
    }
    @RequestMapping("/count/getsales")
    public void countSales(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int a = this.jixingService.counttuple();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(a);
        response.getWriter().close();
    }
    @RequestMapping("/count/getComment")
    public void countComment(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int a = this.newsCommentService.countComment();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(a);
        response.getWriter().close();
    }
    @RequestMapping("/count/getNews")
    public void countNews(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int a = this.newsService.countNews();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(a);
        response.getWriter().close();
    }
    @RequestMapping("/count/getVideo")
    public void countVideo(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int a = this.videoService.countVideo();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(a);
        response.getWriter().close();
    }
    @RequestMapping("/count/getdatabaseUser")
    public void countdatabaseUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int a = this.databaseUserService.countdatabaseUser();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(a);
        response.getWriter().close();
    }
    @RequestMapping(value = "/update/Jixing",method = RequestMethod.POST)
    public void updateJixing(@RequestParam("id") int id,@RequestParam("imgUrl") String imgUrl,@RequestParam("descri") String descri,@RequestParam("price") String price,
                             HttpServletRequest request, HttpServletResponse response)throws Exception{
        Jixing j = new Jixing();
        j.setDescri(descri);
        j.setId(id);
        j.setImgUrl(imgUrl);
        j.setPrice(price);
        this.jixingService.update(j);

    }
    @RequestMapping(value = "/update/news" , method = RequestMethod.POST)
    public void updateNews(@RequestParam("id") int id,@RequestParam("tag") String tag,@RequestParam("title") String title,
                           @RequestParam("imgUrl") String imgUrl, @RequestParam("content") String content,@RequestParam("digest") String digest,
                           HttpServletRequest request, HttpServletResponse response)throws Exception{
        news n = new news();
        n.setContent(content);
        n.setDigest(digest);
        n.setId(id);
        n.setImgUrl(imgUrl);
        n.setTag(tag);
        n.setTitle(title);
        this.newsService.update(n);
    }

    @RequestMapping(value = "/update/Video",method = RequestMethod.POST)
    public void updateVideo(@RequestParam("vid") int vid,@RequestParam("imgUrl") String imgUrl,@RequestParam("videoUrl") String videoUrl,
                            @RequestParam("descri") String descri,HttpServletRequest request, HttpServletResponse response)throws Exception{
        Video v = new Video();
        v.setDescri(descri);
        v.setImgUrl(imgUrl);
        v.setVid(vid);
        v.setVideoUrl(videoUrl);
        this.videoService.update(v);

    }
    @RequestMapping(value = "/update/Comment",method = RequestMethod.POST)
    public void updateComment(@RequestParam("cid") int cid,@RequestParam("id") int id,@RequestParam("userImg") String userImg,
                              @RequestParam("userNickname") String userNickname,@RequestParam("time") Date date,
                              @RequestParam("content") String content, HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.out.println(date);
        NewsComment ns = new NewsComment();
        ns.setUserNickname(userNickname);
        ns.setUserImg(userImg);
        ns.setTime(date);
        ns.setCid(cid);
        ns.setId(id);
        ns.setContent(content);
        this.newsCommentService.update(ns);
    }
    @RequestMapping(value = "/update/databaseUser",method = RequestMethod.POST)
    public void updatedatabase(@RequestParam("id") int id,@RequestParam("account") String account,@RequestParam("password") String password,
                               @RequestParam("isAdmin") boolean isAdmin, HttpServletRequest request, HttpServletResponse response)throws Exception{
        databaseUser u = new databaseUser();
        u.setPassword(password);
        u.setAccount(account);
        u.setAdmin(isAdmin);
        u.setId(id);
        this.databaseUserService.update(u);

    }
    @RequestMapping("/getAllUser")
    public void getAllUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        databaseUser[] a = this.databaseUserService.getAll();
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/search/news")
    public void searchNews(String title, HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        news[] a = this.newsService.search(title);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/search/Video")
    public void searchVideo(String descri, HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Video[] a = this.videoService.search(descri);
        response.getWriter().write("[");
        for(int i=0;i<a.length-1;i++){
            System.out.println(a[i]);
            response.getWriter().write(mapper.writeValueAsString(a[i]));
            response.getWriter().write(",");
        }
        response.getWriter().write(mapper.writeValueAsString(a[a.length-1]));
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping("/search/Jixing")
    public void searchJixing(String low,String high,HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Jixing[] a = this.jixingService.search(2);
        boolean qq = false;
        int b = a.length;
        response.getWriter().write("[");
        for(int i=0;i<b;i++){
            if(util.isBetween(low,high,a[i].getPrice())){
                if(qq) {
                    response.getWriter().write(",");
                }
                response.getWriter().write(mapper.writeValueAsString(a[i]));
                qq = true;
            }
        }
        response.getWriter().write("]");
        response.getWriter().close();
    }
    @RequestMapping(value = "/add/news",method = RequestMethod.POST)
    public void addNews(@RequestParam("tag") String tag,@RequestParam("title") String title,@RequestParam("digest") String digest,
                        @RequestParam("content") String content,@RequestParam("imgUrl") String imgUrl,
                        HttpServletRequest request, HttpServletResponse response)throws Exception{
        news n = new news();
        n.setTitle(title);
        n.setTag(tag);
        n.setImgUrl(imgUrl);
        n.setDigest(digest);
        n.setContent(content);
        this.newsService.insert(n);

    }
    @RequestMapping(value = "/add/Video",method = RequestMethod.POST)
    public void addVideo(@RequestParam("imgUrl") String imgUrl,@RequestParam("videoUrl") String videoUrl,
                         @RequestParam("descri") String descri,HttpServletRequest request,
                         HttpServletResponse response)throws Exception{
        Video v = new Video();
        v.setVideoUrl(videoUrl);
        v.setImgUrl(imgUrl);
        v.setDescri(descri);
        this.videoService.add(v);

    }
    @RequestMapping(value = "/add/User",method = RequestMethod.POST)
    public void addUser(@RequestParam("account") String account,@RequestParam("password") String password,HttpServletRequest request,
                        HttpServletResponse response)throws Exception{
        databaseUser u = new databaseUser();
        u.setAdmin(true);
        u.setAccount(account);
        u.setPassword(password);
        this.databaseUserService.add(u);
    }


}
