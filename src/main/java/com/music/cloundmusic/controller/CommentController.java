package com.music.cloundmusic.controller;

import com.music.cloundmusic.dto.UserComment;
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
import java.util.HashMap;
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
    public List<UserComment> getComment(int keyId,String type,String types){
        List<UserComment> list=commentService.getComment(keyId,"music","likes");
        if(list.size()>0){
            for(UserComment c:list){
                c.setUsercover(relativePath+c.getUsercover());
            }
        }
        return list;
    }
    /**
     * @author: QiuYin
     * @description: 增加评论的点赞数
     * @date: 2020/7/11 14:41
     * @param commentId 评论的id
     * @return int
     */
    @ResponseBody
    @RequestMapping(value = "/addLikes",method = RequestMethod.PUT)
    public int addLikes(int commentId,HttpServletRequest request){

        Integer commentLikesId=(Integer)request.getSession().getAttribute("commentLikesId"+commentId);
        if(commentLikesId==null){
            request.getSession().setAttribute("commentLikesId"+commentId,1);
            commentService.addLikes(commentId);
            return 1;
        }else {
            if(commentLikesId==1){
                request.getSession().setAttribute("commentLikesId"+commentId,-1);
                return -1;
            }else {
                request.getSession().setAttribute("commentLikesId"+commentId,1);
                return 1;
            }
        }

    }
    //增加评论
    @ResponseBody
    @RequestMapping(value = "/setComment",method = RequestMethod.GET)
    public Comment setComment(Comment comment){
        comment.setCreatetime(new Date(new java.util.Date().getTime()));
        comment.setText(comment.getText().replaceAll("\n","<br>"));
        commentService.setComment(comment);
        return comment;
    }

    //添加评论修改
    @ResponseBody
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public String addComment(int userId, int keyId, String type, String commentText){
        Comment comment=new Comment(userId,keyId,type,commentText,new Date(new java.util.Date().getTime()));
        commentService.setComment(comment);
        return "SUCCESS";
    }

}
