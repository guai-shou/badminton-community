package com.cloud.badminton.project.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.user.entity.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:05
 */
@Mapper
public interface LikeMapper extends BaseMapper<Like> {

    @Delete("delete from `like` where invitation_id=#{invitationId} and u_id=#{uid}")
    int deleteByInvitationId(Like like);

    @Insert("insert into `like`(u_id, invitation_id) VALUE (#{uid}, #{invitationId})")
    int insertLike(Like like);
}
