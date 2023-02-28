package com.cloud.badminton.project.invitation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.entity.TagMapping;

import java.util.List;

public interface TagService extends IService<Tag> {
    /*获取全部标签*/
    List<Tag> getTagList();
    /*插入标签*/
    int insertTag(Tag tag);
    /*更新标签*/
    int updateTag(Tag tag);
    /*根据ID删除标签*/
    int deleteTagByIds(List<Integer> ids);
    /*根据ID获取标签*/
    Tag getTagById(Long id);

    /*删除标签与文章全部关联*/
    int deleteTagMapping(Long invitationId);
    /*以文章为重点, 根据文章添加标签*/
    int insertTagMappingByInvitationId(Long invitationId, List<Long> tagIds);
    /*添加标签与文章关联*/
    int insertTagMapping(TagMapping tagMapping);
    /*更新标签与文章关联*/
    int updateTagMapping(Long invitationId, List<Long> tagIds);
    /*根据文章ID查询标签*/
    List<Tag> getTagListByInvitationId(Long invitationId);
    /*根据文章名称判断是否存在*/
    int getTagByName(String name);
    /*根据前端查询指定标签 参数可改*/
    List<Tag> getTagListByName(String name);
}
