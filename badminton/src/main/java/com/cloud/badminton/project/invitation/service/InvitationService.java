package com.cloud.badminton.project.invitation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.entity.Invitation;
import com.cloud.badminton.project.invitation.entity.vo.InvitationVo;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:59
 */
public interface InvitationService extends IService<Invitation> {
    /*查询所有文章*/
    List<Invitation> getInvitationList();
    /*根据ID查文章*/
    Invitation getInvitationById(Long id);
    /*插入文章*/
    int insertInvitation(Invitation invitation);
    /*更新文章*/
    int updateInvitation(Invitation invitation);
    /*根据ID删除文章*/
    int deleteInvitationById(Long id);
    /*根据文章ID获取标签*/
    List<String> getInvitationTagList(Long id);
    /*喜欢值 +1*/
    int incrementInvitationLike(Long id);
    /*根据ID查询评论*/
    List<Comment> getInvitationCommentListByInvId(Long id);
    /*根据ID列表删除文章*/
    int batchDeleteInvitationByIds(List<Long> ids);
    /*根据前端条件查询文章 参数可加字段*/
    List<Invitation> getInvitationList(InvitationVo invitationVo);
}
