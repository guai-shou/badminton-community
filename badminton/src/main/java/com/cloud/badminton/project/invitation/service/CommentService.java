package com.cloud.badminton.project.invitation.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.invitation.entity.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentService extends IService<Comment> {
    /*根据文章ID获取全部评论*/
    List<Comment> getCommentListByInvitationId(Long invitationId);
    /*插入评论*/
    int insertComment(Comment comment);
    /*更新评论*/
    //int updateComment(Comment comment);
    /*删除评论*/
    int deleteCommentByIds(List<Integer> ids);
    /*根据ID获取评论*/
    Comment getCommentById(Long id);
    /*获取全部评论*/
    List<Comment> getCommentList();
    /*根据文章ID删除评论*/
    int deleteCommentByInvitationId(Long id);
    /*根据前端查询评论  参数可改*/
    List<Comment> getComment(Comment comment);

}
