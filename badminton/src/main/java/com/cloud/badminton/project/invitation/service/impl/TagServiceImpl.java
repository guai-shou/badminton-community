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
    @Override
    public List<Tag> getTagList() {
        return list();
    }

    @Override
    public int insertTag(Tag tag) {
        return baseMapper.insert(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return baseMapper.updateById(tag);
    }

    @Override
    public int deleteTagByIds(List<Integer> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public Tag getTagById(Long id) {
        return getById(id);
    }

    @Override
    public int deleteTagMapping(TagMapping tagMapping) {
        return baseMapper.deleteTagMapping(tagMapping);
    }

    @Override
    public int insertTagMappingByInvitationId(Long invitationId, List<Long> tagIds) {
        // 控制参数不为空
        return baseMapper.insertTagMappingByInvitationId(invitationId, tagIds);
    }

    @Override
    public int insertTagMapping(TagMapping tagMapping) {
        return baseMapper.insertTagMapping(tagMapping);
    }

    @Override
    public int updateTagMapping(Long invitationId, List<Long> tagIds) {
        // 1. 先删除该文章全部标签

        // 2. 重新执行插入标签方法
        return 0;
    }

    @Override
    public List<Tag> getTagListByName(String name) {
        return baseMapper.getTagListByName(name);
    }
}
