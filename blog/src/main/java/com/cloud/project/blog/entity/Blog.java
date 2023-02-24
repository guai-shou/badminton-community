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
 * 博客表
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Getter
@Setter
@TableName("blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类id
     */
    @TableField("category_id")
    private Long categoryId;

    /**
     * 文章标题
     */
    @TableField("title")
    private String title;

    /**
     * 摘要
     */
    @TableField("summary")
    private String summary;

    /**
     * 图片类型(0没有, 1小图, 2大图)
     */
    @TableField("header_img_type")
    private Integer headerImgType;

    /**
     * 封面图片地址
     */
    @TableField("header_img")
    private String headerImg;

    /**
     * 解析后的html内容
     */
    @TableField("html_content")
    private String htmlContent;

    /**
     * 正文内容
     */
    @TableField("content")
    private String content;

    /**
     * 文章状态(1发表,2草稿箱)
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否允许评论(1允许,0不允许)
     */
    @TableField("comment")
    private Integer comment;

    /**
     * 是否允许其他人查看
     */
    @TableField("display")
    private Integer display;

    /**
     * 推荐
     */
    @TableField("support")
    private Integer support;

    /**
     * 权重
     */
    @TableField("weight")
    private Integer weight;

    /**
     * 点赞数
     */
    @TableField("like")
    private Long like;

    /**
     * 点击数
     */
    @TableField("click")
    private Long click;

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
