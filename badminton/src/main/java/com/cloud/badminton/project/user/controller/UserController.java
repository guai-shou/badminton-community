package com.cloud.badminton.project.user.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserVo;
import com.cloud.badminton.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 12:59
 */
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*根据用户ID查询信息*/
    @GetMapping("/user/{id}")
    UserVo getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    /*增加用户*/
    @PostMapping("/user/add")
    String insertUser(@Validated(Publish.class) @RequestBody User user) {
        final int i = userService.insertUser(user);
        return "增加成功";
    }
    /*删除用户*/
    @DeleteMapping("/user/delete")
    String deleteUserByIds(@RequestBody List<Long> ids) {
        final int i = userService.deleteUserByIds(ids);
        return "删除成功";
    }
    /*更新用户*/
    @PostMapping("/user/update")
    String updateUser(@RequestBody User user) {
        final int i = userService.updateUser(user);
        return "更新成功";
    }
    /*判断用户名*/
    @GetMapping("/user/getName")
    String getUserName(@RequestBody String name) {
        final int i = userService.getUserName(name);
        return "用户名已存在";
    }
    /*根据前端条件查询用户 参数可加字段*/
    @GetMapping("/user")
    List<UserVo> getUserList(@RequestBody UserVo userVo) {
        return userService.getUserList(userVo);
    }
}