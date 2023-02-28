package com.cloud.badminton.project.user.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 1:03
 */
/*返回给前端用户 不含密码*/
@Data
public class UserVo {
    private Long id;

    private String name;

    private String nickName;

    private String avatar;

    @TableField("space_bg")
    private String spaceBg;

    private String description;

    private LocalDate createTime;
}
