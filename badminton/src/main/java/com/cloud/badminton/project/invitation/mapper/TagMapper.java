package com.cloud.badminton.project.invitation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.entity.TagMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    int deleteTagMapping(Long invitationId);


    @Insert("insert into invitation_con_tag(invitation_id, tag_id) value(#{invitationId}, #{tagId})")
    int insertTagMapping(TagMapping tagMapping);


    List<Tag> getTagListByName(String name);

    int insertTagMappingByInvitationId(Long invitationId, List<Long> tagIds);

    @Select("select t.* from tag t, invitation_con_tag ict " +
            "where ict.invitation_id=#{invitationId} and ict.tag_id=t.id")
    List<Tag> getTagListByInvitationId(Long invitationId);

    @Select("select count(name) from tag where name=#{name}")
    int getTagByName(String name);
}
