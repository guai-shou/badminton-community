package com.cloud.badminton.project.invitation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.entity.Invitation;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.entity.vo.InvitationVo;
import com.cloud.badminton.project.invitation.mapper.InvitationMapper;
import com.cloud.badminton.project.invitation.service.CommentService;
import com.cloud.badminton.project.invitation.service.InvitationService;
import com.cloud.badminton.project.invitation.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:00
 */
@Service
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper, Invitation> implements InvitationService {

    @Autowired
    CommentService commentService;

    @Override
    public List<Invitation> getInvitationList() {
        return list();
    }

    @Override
    public Invitation getInvitationById(Long id) {
        return getById(id);
    }

    @Override
    public int insertInvitation(Invitation invitation) {
        return baseMapper.insert(invitation);
    }

    @Override
    public int updateInvitation(Invitation invitation) {
        return baseMapper.updateById(invitation);
    }

    @Override
    public int deleteInvitationById(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<String> getInvitationTagList(Long id) {
        return baseMapper.getInvitationTagList(id);
    }

    @Override
    public int incrementInvitationLike(Long id) {
        return baseMapper.incrementInvitationLike(id);
    }

    @Override
    public List<Comment> getInvitationCommentListByInvId(Long id) {
        return baseMapper.getInvitationCommentListByInvId(id);
    }

    @Override
    public int batchDeleteInvitationByIds(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public List<Invitation> getInvitationList(InvitationVo invitationVo) {
        return baseMapper.getInvitationList(invitationVo);
    }
}
