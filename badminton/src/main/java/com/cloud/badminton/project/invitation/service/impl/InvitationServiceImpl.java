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
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:00
 */
@Service
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper, Invitation> implements InvitationService {

    @Autowired
    CommentService commentService;
    @Autowired
    TagService tagService;

    /*查询所有文章*/
    @Override
    public List<Invitation> getInvitationList() {
        /*查询所有文章, 补上所有标签*/
        final List<Invitation> list = list();
        list.forEach(item -> {
            final List<Tag> tagList = tagService.getTagListByInvitationId(item.getId());
            item.setTag(tagList);
        });
        return list;
    }

    /*根据ID查文章*/
    @Override
    public Invitation getInvitationById(Long id) {
        /*1. 查询指定文章*/
        final Invitation invitation = getById(id);
        if (invitation != null) {
            /*2. 补充评论内容*/
            final List<Comment> commentList = commentService.getCommentListByInvitationId(invitation.getId());
            invitation.setCommentList(commentList);
            /*3. 补充标签内容*/
            final List<Tag> tagList = tagService.getTagListByInvitationId(invitation.getId());
            invitation.setTag(tagList);
            return invitation;
        }
        return null;
    }

    @Transactional
    /*插入文章*/
    @Override
    public int insertInvitation(Invitation invitation) {
        /*插入文章, 并插入标签映射*/
        int i = baseMapper.insert(invitation);
        if (i > 0)
            i = checkTagAndAdd(invitation);
        return i;
    }

    @Transactional
    /*更新文章*/
    @Override
    public int updateInvitation(Invitation invitation) {
        int i = baseMapper.updateById(invitation);
        if (i > 0)
            i = checkTagAndAdd(invitation);
        return i;
    }

    private int checkTagAndAdd(Invitation invitation) {
        /*更新标签*/
        final List<Tag> tagIds = invitation.getTagIds();
        final List<Long> tagList = tagIds.stream().map(Tag::getId).collect(Collectors.toList());
        final List<Tag> hasTag = tagService.getTagList();
        /*如果没有的标签, 则插入标签*/
        boolean flag;
        for (Tag tagId : tagIds) {
            flag = true;
            for (Tag tag : hasTag) {
                if (tag.getId().equals(tagId.getId())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                tagService.insertTag(tagId);
        }
        return tagService.updateTagMapping(invitation.getId(), tagList);
    }

    @Transactional
    /*根据ID删除文章*/
    @Override
    public int deleteInvitationById(Long id) {
        final int i = baseMapper.deleteById(id);
        tagService.deleteTagMapping(id);
        commentService.deleteCommentByInvitationId(id);
        return i;
    }

    /*根据文章ID获取标签*/
    @Override
    public List<String> getInvitationTagList(Long id) {
        return baseMapper.getInvitationTagList(id);
    }

    /*喜欢值 +1*/
    @Override
    public int incrementInvitationLike(Long id) {
        return baseMapper.incrementInvitationLike(id);
    }

    /*根据ID查询评论*/
    @Override
    public List<Comment> getInvitationCommentListByInvId(Long id) {
        return commentService.getCommentListByInvitationId(id);
    }

    /*根据ID列表删除文章*/
    @Override
    public int batchDeleteInvitationByIds(List<Long> ids) {
        int sum = 0;
        for (Long id : ids) {
            final int i = deleteInvitationById(id);
            sum += i;
        }
        return sum;
    }

    /*根据前端条件查询文章 参数可加字段*/
    @Override
    public List<Invitation> getInvitationList(InvitationVo invitationVo) {
        final List<Invitation> invitationList = baseMapper.getInvitationList(invitationVo);
        invitationList.forEach(item -> {
            final List<Tag> tagList = tagService.getTagListByInvitationId(item.getId());
            item.setTag(tagList);
        });
        return invitationList;
    }
}
