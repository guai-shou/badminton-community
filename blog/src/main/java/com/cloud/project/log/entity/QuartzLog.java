package com.cloud.project.log.entity;

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
 * Job日志
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Getter
@Setter
@TableName("quartz_log")
public class QuartzLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * Bean的名称
     */
    @TableField("bean_name")
    private String beanName;

    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;

    /**
     * 参数
     */
    @TableField("method_params")
    private String methodParams;

    /**
     * corn表达式
     */
    @TableField("cron_expression")
    private String cronExpression;

    /**
     * 异常信息
     */
    @TableField("exception")
    private String exception;

    /**
     * 返回结果值
     */
    @TableField("result")
    private String result;

    /**
     * 1表示成功,0表示失败
     */
    @TableField("status")
    private Integer status;

    /**
     * 耗时
     */
    @TableField("cost")
    private Long cost;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("create_by")
    private String createBy;

    @TableField("delete_time")
    private LocalDateTime deleteTime;

    @TableField("delete_by")
    private String deleteBy;

    /**
     * 逻辑删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
