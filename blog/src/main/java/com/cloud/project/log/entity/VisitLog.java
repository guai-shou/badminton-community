package com.cloud.project.log.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 访问日志表
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Getter
@Setter
@TableName("visit_log")
public class VisitLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * IP地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 页面ID
     */
    @TableField("page_id")
    private String pageId;

    /**
     * 地理位置
     */
    @TableField("location")
    private String location;

    /**
     * 浏览器
     */
    @TableField("browser")
    private String browser;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    @TableField("entry_url")
    private String entryUrl;

    /**
     * 访问URL地址
     */
    @TableField("url")
    private String url;

    @TableField("error_msg")
    private String errorMsg;

    /**
     * 状态,1表示成功,0表示失败
     */
    @TableField("status")
    private Integer status;

    /**
     * 访问模块
     */
    @TableField("title")
    private String title;

    /**
     * 爬虫
     */
    @TableField("spider")
    private String spider;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("delete_time")
    private LocalDateTime deleteTime;

    @TableField("create_by")
    private String createBy;

    @TableField("delete_by")
    private String deleteBy;


}
