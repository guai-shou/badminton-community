package com.cloud.badminton.project.invitation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.entity.TagMapping;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    int deleteTagMapping(TagMapping tagMapping);


    @Insert("insert into invitation_con_tag(invitation_id, tag_id) value(#{invitationId}, #{tagId})")
    int insertTagMapping(TagMapping tagMapping);


    List<Tag> getTagListByName(String name);

    int insertTagMappingByInvitationId(Long invitationId, List<Long> tagIds);
}
