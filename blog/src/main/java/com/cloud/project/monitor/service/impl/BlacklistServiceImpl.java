package com.cloud.project.monitor.service.impl;

import com.cloud.project.monitor.entity.Blacklist;
import com.cloud.project.monitor.mapper.BlacklistMapper;
import com.cloud.project.monitor.service.IBlacklistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统黑名单 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist> implements IBlacklistService {

}
