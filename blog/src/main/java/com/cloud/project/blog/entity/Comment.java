package com.cloud.project.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Getter
@Setter
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * Email地址
     */
    @TableField("email")
    private String email;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 地理位置
     */
    @TableField("location")
    private String location;

    /**
     * 系统
     */
    @TableField("os")
    private String os;

    /**
     * 浏览器
     */
    @TableField("browser")
    private String browser;

    /**
     * 父评论的id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * qq号码
     */
    @TableField("qq_num")
    private String qqNum;

    /**
     * 头像地址
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 页面id
     */
    @TableField("page_id")
    private Long pageId;

    /**
     * 页面的url
     */
    @TableField("url")
    private String url;

    /**
     * 显示(1显示,0不显示)
     */
    @TableField("dispaly")
    private Integer dispaly;

    /**
     * 点赞
     */
    @TableField("good")
    private Long good;

    /**
     * 踩
     */
    @TableField("bad")
    private Long bad;

    /**
     * 评论内容
     */
    @TableField("content")
    private String content;

    /**
     * 评论内容解析html
     */
    @TableField("html_content")
    private String htmlContent;

    /**
     * 是否需要邮件回复
     */
    @TableField("replay")
    private Integer replay;

    /**
     * 回复评论的id
     */
    @TableField("replay_id")
    private Long replayId;

    /**
     * 是否是作者回复
     */
    @TableField("admin_replay")
    private Integer adminReplay;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 删除者
     */
    @TableField("delete_by")
    private String deleteBy;

    /**
     * 删除时间
     */
    @TableField("delete_time")
    private LocalDateTime deleteTime;

    /**
     * 逻辑删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
