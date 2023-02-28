package com.cloud.badminton.project.invitation.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.result.ResultVo;
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
@RequestMapping("/api")
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
    public ResultVo  insertInvitation(@Validated(Publish.class) @RequestBody Invitation invitation) {
        int i = invitationService.insertInvitation(invitation);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    @PostMapping("/invitation/update")
    public ResultVo  updateInvitation(@Validated(Publish.class) @RequestBody Invitation invitation) {
        final int i = invitationService.updateInvitation(invitation);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    @DeleteMapping("/invitation/{id}")
    public ResultVo  deleteInvitationById(@PathVariable Long id) {
        final int i = invitationService.deleteInvitationById(id);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    @GetMapping("/invitationTagList/{id}")
    public List<String> getInvitationTagList(@PathVariable Long id) {
        return invitationService.getInvitationTagList(id);
    }

    @PostMapping("/invitation/{id}")
    public ResultVo incrementInvitationLike(@PathVariable Long id) {
        int i = invitationService.incrementInvitationLike(id);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    @GetMapping("/invitationCommentList/{id}")
    public List<Comment> getInvitationCommentListByInvId(@PathVariable Long id) {
        return invitationService.getInvitationCommentListByInvId(id);
    }

    @DeleteMapping("/invitation")
    public ResultVo batchDeleteInvitationByIds(@RequestBody List<Long> ids) {
        int i = invitationService.batchDeleteInvitationByIds(ids);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    @GetMapping("/invitation")
    public List<Invitation> getInvitationList(@RequestBody InvitationVo invitationVo) {
        return invitationService.getInvitationList(invitationVo);
    }
}
