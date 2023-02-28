package com.cloud.badminton.project.invitation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.invitation.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:57
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select * from comment where comment.invitation_id = #{invitationId}")
    List<Comment> getCommentList(Long invitationId);

    List<Comment> getComment(Comment comment);
}
