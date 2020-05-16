package com.music.cloundmusic.controller;

import com.music.cloundmusic.entity.Comment;
import com.music.cloundmusic.entity.User;
import com.music.cloundmusic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Value("${relativePath}")
    private String relativePath;
    private CommentService commentService;
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
//获取热门评论
    @ResponseBody
    @RequestMapping(value = "/getComment",method = RequestMethod.GET)
    public List<Comment> getComment(int keyId,String type,String types){
        List<Comment> list=commentService.getComment(keyId,type,types);
        if(list.size()>0){
            for(Comment c:list){
                c.getUser().setCover(relativePath+c.getUser().getCover());
            }
        }
        return list;
    }
//点赞
    @ResponseBody
    @RequestMapping(value = "/addLikes",method = RequestMethod.PUT)
    public int addLikes(int commentId,HttpServletRequest request){
        String strId=String.valueOf(commentId);
        @SuppressWarnings("unchecked")
        ArrayList<String> list=(ArrayList<String>)request.getSession().getAttribute("commentLikesList");
        if(list==null){
            list=new ArrayList<>();
        }
        if(list.contains(strId)){
            return 0;
        }else {
            list.add(strId);
            commentService.addLikes(commentId);
            request.getSession().setAttribute("commentLikesList",list);
            return 1;
        }
    }
    //增加评论
    @ResponseBody
    @RequestMapping(value = "/setComment",method = RequestMethod.POST)
    public Comment setComment(int keyId,String type,String commentText,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("userMsg");
        if(user==null)
            return null;
        Comment comment=new Comment(user.getUserid(),keyId,type,commentText,new Date(new java.util.Date().getTime()));
        commentService.setComment(comment);
        comment.setUser(user);
        comment.setLikes(0);
        return comment;
    }
}
