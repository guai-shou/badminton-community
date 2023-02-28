package com.cloud.badminton.project.invitation.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 23:30
 */
@RequestMapping("/api")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    /*根据文章ID获取全部评论*/
    @GetMapping("/commentList/{invitationId}")
    List<Comment> getCommentListByInvitationId(@PathVariable Long invitationId) {
        return commentService.getCommentListByInvitationId(invitationId);
    }
    /*插入评论*/
    @PostMapping("/comment/add")
    ResultVo insertComment(@Validated(Publish.class) @RequestBody Comment comment) {
        final int i = commentService.insertComment(comment);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }
    /*更新评论*/
    //int updateComment(Comment comment);
    /*删除评论*/
    @DeleteMapping("/comment")
    ResultVo deleteCommentByIds(@RequestBody List<Integer> ids) {
        final int i = commentService.deleteCommentByIds(ids);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }
    /*根据ID获取评论*/
    //@GetMapping("/comment/{id}")
    //Comment getCommentById(@PathVariable Long id) {
    //    return commentService.getCommentById(id);
    //}
    /*获取全部评论*/
    @GetMapping("/commentList")
    List<Comment> getCommentList() {
        return commentService.getCommentList();
    }

    /*根据前端查询评论  参数可改*/
    @GetMapping("/comment")
    List<Comment> getComment(@Validated(Publish.class) @RequestBody Comment comment) {
        return commentService.getComment(comment);
    }

}
