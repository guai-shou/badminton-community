package com.cloud.badminton.project.invitation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.mapper.CommentMapper;
import com.cloud.badminton.project.invitation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:59
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<Comment> getCommentListByInvitationId(Long invitationId) {
        return baseMapper.getCommentList(invitationId);
    }

    @Override
    public int insertComment(Comment comment) {
        return baseMapper.insert(comment);
    }

    //@Override
    //public int updateComment(Comment comment) {
    //    return baseMapper.updateById(comment);
    //}

    @Override
    public int deleteCommentByIds(List<Integer> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public Comment getCommentById(Long id) {
        return getById(id);
    }

    @Override
    public List<Comment> getCommentList() {
        return list();
    }


    // TODO 后续有需要在开放查询
    @Override
    public List<Comment> getComment(Comment comment) {
        return baseMapper.getComment(comment);
    }
}
