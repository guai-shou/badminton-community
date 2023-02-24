package com.cloud.project.log.service.impl;

import com.cloud.project.log.entity.QuartzLog;
import com.cloud.project.log.mapper.QuartzLogMapper;
import com.cloud.project.log.service.IQuartzLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Job日志 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class QuartzLogServiceImpl extends ServiceImpl<QuartzLogMapper, QuartzLog> implements IQuartzLogService {

}
