package com.cloud.project.system.service.impl;

import com.cloud.project.system.entity.QuartzJob;
import com.cloud.project.system.mapper.QuartzJobMapper;
import com.cloud.project.system.service.IQuartzJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class QuartzJobServiceImpl extends ServiceImpl<QuartzJobMapper, QuartzJob> implements IQuartzJobService {

}
