package com.cloud.project.log.service.impl;

import com.cloud.project.log.entity.LoginLog;
import com.cloud.project.log.mapper.LoginLogMapper;
import com.cloud.project.log.service.ILoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
