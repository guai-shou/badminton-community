package com.cloud.project.log.service.impl;

import com.cloud.project.log.entity.OperateLog;
import com.cloud.project.log.mapper.OperateLogMapper;
import com.cloud.project.log.service.IOperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements IOperateLogService {

}
