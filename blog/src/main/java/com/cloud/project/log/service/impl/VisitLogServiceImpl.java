package com.cloud.project.log.service.impl;

import com.cloud.project.log.entity.VisitLog;
import com.cloud.project.log.mapper.VisitLogMapper;
import com.cloud.project.log.service.IVisitLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 访问日志表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class VisitLogServiceImpl extends ServiceImpl<VisitLogMapper, VisitLog> implements IVisitLogService {

}
