package com.cloud.project.blog.service.impl;

import com.cloud.project.blog.entity.Tag;
import com.cloud.project.blog.mapper.TagMapper;
import com.cloud.project.blog.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客标签表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
