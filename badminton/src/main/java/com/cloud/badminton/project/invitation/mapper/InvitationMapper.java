package com.cloud.badminton.project.invitation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.entity.Invitation;
import com.cloud.badminton.project.invitation.entity.vo.InvitationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InvitationMapper extends BaseMapper<Invitation> {
    @Select("select t.name from invitation inv, tag t, invitation_con_tag ict " +
            "where #{id}=inv.id and t.id=ict.tag_id and ict.invitation_id=inv.id")
    List<String> getInvitationTagList(Long id);

    @Update("update invitation ivt set ivt.stars = ivt.stars + 1 where ivt.id = #{id}")
    int incrementInvitationLike(Long id);

    @Select("select c.* from invitation ivt, comment c where #{id} = c.invitation_id;")
    List<Comment> getInvitationCommentListByInvId(Long id);

    List<Invitation> getInvitationList(InvitationVo invitationVo);


}
