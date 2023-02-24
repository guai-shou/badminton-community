package com.cloud.project.blog.service.impl;

import com.cloud.project.blog.entity.Blog;
import com.cloud.project.blog.mapper.BlogMapper;
import com.cloud.project.blog.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
