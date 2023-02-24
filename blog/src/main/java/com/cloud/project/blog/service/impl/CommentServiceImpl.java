package com.cloud.project.blog.service.impl;

import com.cloud.project.blog.entity.Comment;
import com.cloud.project.blog.mapper.CommentMapper;
import com.cloud.project.blog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-01-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
