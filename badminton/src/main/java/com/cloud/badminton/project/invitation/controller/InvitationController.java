package com.cloud.badminton.project.invitation.controller;

import com.cloud.badminton.project.invitation.entity.Comment;
import com.cloud.badminton.project.invitation.entity.Invitation;
import com.cloud.badminton.project.invitation.entity.vo.InvitationVo;
import com.cloud.badminton.project.invitation.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:13
 */
@RequestMapping("/api/invitation")
@RestController
public class InvitationController {

    @Autowired
    InvitationService invitationService;

    @GetMapping("/invitationList")
    public List<Invitation> getInvitationList() {
        return invitationService.getInvitationList();
    }

    @GetMapping("/invitation/{id}")
    public Invitation getInvitationById(@PathVariable Long id) {
        return invitationService.getInvitationById(id);
    }

    @PostMapping("/invitation/add")
    public String  insertInvitation(Invitation invitation) {
        int i = invitationService.insertInvitation(invitation);
        return "插入成功";
    }

    @PostMapping("/invitation/update")
    public String  updateInvitation(@Validated(Invitation.Publish.class) @RequestBody Invitation invitation) {
        final int i = invitationService.updateInvitation(invitation);
        return "插入成功";
    }

    @DeleteMapping("/invitation/{id}")
    public String  deleteInvitationById(@PathVariable Long id) {
        final int i = invitationService.deleteInvitationById(id);
        return "插入成功";
    }

    @GetMapping("/invitationTagList/{id}")
    public List<String> getInvitationTagList(@PathVariable Long id) {
        return invitationService.getInvitationTagList(id);
    }

    @PostMapping("/invitation/{id}")
    public String incrementInvitationLike(@PathVariable Long id) {
        int i = invitationService.incrementInvitationLike(id);
        return "插入成功";
    }

    @GetMapping("/invitationCommentList/{id}")
    public List<Comment> getInvitationCommentListByInvId(@PathVariable Long id) {
        return invitationService.getInvitationCommentListByInvId(id);
    }

    @DeleteMapping("/invitation")
    public String batchDeleteInvitationByIds(@RequestBody List<Long> ids) {
        int i = invitationService.batchDeleteInvitationByIds(ids);
        return "插入成功";
    }

    @GetMapping("/invitation")
    public List<Invitation> getInvitationList(@RequestBody InvitationVo invitationVo) {
        return invitationService.getInvitationList(invitationVo);
    }
}
