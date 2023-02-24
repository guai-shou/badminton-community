package com.cloud.project.blog.service.impl;

import com.cloud.project.blog.entity.Category;
import com.cloud.project.blog.mapper.CategoryMapper;
import com.cloud.project.blog.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
