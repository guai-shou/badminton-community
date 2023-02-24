package com.cloud.project.system.entity;

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
 * 友链表
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Getter
@Setter
@TableName("link")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 友链名称
     */
    @TableField("title")
    private String title;

    /**
     * 友链地址
     */
    @TableField("url")
    private String url;

    /**
     * 友链描述
     */
    @TableField("description")
    private String description;

    /**
     * 网站图片
     */
    @TableField("header_img")
    private String headerImg;

    /**
     * 审核状态(1通过,0未审核)
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否显示友链
     */
    @TableField("display")
    private Integer display;

    /**
     * 站长邮箱地址
     */
    @TableField("email")
    private String email;

    /**
     * 权重
     */
    @TableField("weight")
    private Long weight;

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
