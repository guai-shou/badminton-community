package com.cloud.badminton.project.invitation.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.cloud.badminton.project.invitation.entity.Tag;
import com.cloud.badminton.project.invitation.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 11:35
 */
@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    TagService tagService;

    /*获取全部标签*/
    @GetMapping("/tag/tagList")
    List<Tag> getTagList() {
        return tagService.getTagList();
    }
    /*插入标签*/
    @PostMapping("/tag/add")
    ResultVo insertTag(@Validated(Publish.class) @RequestBody Tag tag) {
        final int i = tagService.insertTag(tag);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }
    /*更新标签*/
    @PostMapping("/tag/update")
    ResultVo updateTag(@Validated(Publish.class) @RequestBody Tag tag) {
        final int i = tagService.updateTag(tag);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }
    /*根据ID删除标签*/
    @DeleteMapping("/tag")
    ResultVo deleteTagByIds(@RequestBody List<Integer> ids) {
        final int i = tagService.deleteTagByIds(ids);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    /*根据前端查询指定标签 参数可改*/
    @GetMapping("/tag/")
    List<Tag> getTagListByName(@RequestBody String name) {
        return tagService.getTagListByName(name);
    }
}
