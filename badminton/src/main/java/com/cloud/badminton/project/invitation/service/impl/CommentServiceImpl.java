package com.cloud.badminton.project.invitation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.mapper.CommentMapper;
import com.cloud.badminton.project.invitation.service.CommentService;
import com.cloud.badminton.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:59
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    UserService userService;

    /*根据文章ID获取全部评论*/
    @Override
    public List<Comment> getCommentListByInvitationId(Long invitationId) {
        /*获取文章所有评论*/
        final List<Comment> commentList = baseMapper.getCommentList(invitationId);
        /*获取父评论*/
        final List<Comment> parentComment = commentList.stream()
                .filter(item -> item.getParentId() == null)
                .sorted()
                .collect(Collectors.toList());
        parentComment.forEach(parent -> {
            final List<Comment> childComment = commentList.stream()
                    .sorted()
                    .filter(comment -> comment.getParentId() != null && comment.getParentId().equals(parent.getId()))
                    .collect(Collectors.toList());
            parent.setChildComment(childComment);
        });
        return parentComment;
    }

    /*插入评论*/
    @Override
    public int insertComment(Comment comment) {
        Optional.ofNullable(comment.getReplayId()).ifPresent(item -> {
            comment.setReplyNickName(userService.getUserById(item).getNickName());
        });
        return baseMapper.insert(comment);
    }

    //@Override
    //public int updateComment(Comment comment) {
    //    return baseMapper.updateById(comment);
    //}

    /*删除评论*/
    @Override
    public int deleteCommentByIds(List<Integer> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    /*根据ID获取评论*/
    @Override
    public Comment getCommentById(Long id) {
        return getById(id);
    }

    /*获取全部评论*/
    @Override
    public List<Comment> getCommentList() {
        return list();
    }

    @Override
    public int deleteCommentByInvitationId(Long id) {
        return baseMapper.deleteCommentByInvitationId(id);
    }

    /*根据前端查询评论  参数可改*/
    // TODO 后续有需要在开放查询
    @Override
    public List<Comment> getComment(Comment comment) {
        return baseMapper.getComment(comment);
    }
}
