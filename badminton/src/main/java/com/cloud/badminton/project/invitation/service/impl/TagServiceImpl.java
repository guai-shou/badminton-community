package com.cloud.badminton.project.invitation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.entity.TagMapping;
import com.cloud.badminton.project.invitation.mapper.TagMapper;
import com.cloud.badminton.project.invitation.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:00
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /*获取全部标签*/
    @Override
    public List<Tag> getTagList() {
        return list();
    }

    /*插入标签*/
    @Override
    public int insertTag(Tag tag) {
        /*获取标签名字, 标签不能重复*/
        final int hasTag = getTagByName(tag.getName());
        if (hasTag == 0)
            return baseMapper.insert(tag);
        return 0;
    }

    /*更新标签*/
    @Override
    public int updateTag(Tag tag) {
        return baseMapper.updateById(tag);
    }

    /*根据ID删除标签*/
    @Override
    public int deleteTagByIds(List<Integer> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    /*根据ID获取标签*/
    @Override
    public Tag getTagById(Long id) {
        return getById(id);
    }

    /*删除标签与文章关联*/
    @Override
    public int deleteTagMapping(Long invitationId) {
        return baseMapper.deleteTagMapping(invitationId);
    }

    /*以文章为重点, 根据文章添加标签*/
    @Override
    public int insertTagMappingByInvitationId(Long invitationId, List<Long> tagIds) {
        // 控制参数不为空
        return baseMapper.insertTagMappingByInvitationId(invitationId, tagIds);
    }

    /*添加标签与文章关联*/
    @Override
    public int insertTagMapping(TagMapping tagMapping) {
        return baseMapper.insertTagMapping(tagMapping);
    }


    /*更新标签与文章关联*/
    @Override
    public int updateTagMapping(Long invitationId, List<Long> tagIds) {
        // 1. 先删除该文章全部标签
        deleteTagMapping(invitationId);
        // 2. 重新执行插入标签方法
        insertTagMappingByInvitationId(invitationId, tagIds);
        return 0;
    }

    /*根据文章ID获取标签*/
    @Override
    public List<Tag> getTagListByInvitationId(Long invitationId) {
        return baseMapper.getTagListByInvitationId(invitationId);
    }

    @Override
    public int getTagByName(String name) {
        return baseMapper.getTagByName(name);
    }


    /*根据前端查询指定标签 参数可改*/
    @Override
    public List<Tag> getTagListByName(String name) {
        return baseMapper.getTagListByName(name);
    }
}
