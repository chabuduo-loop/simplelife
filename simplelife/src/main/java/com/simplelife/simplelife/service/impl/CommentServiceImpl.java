package com.simplelife.simplelife.service.impl;

import com.simplelife.simplelife.entity.Comment;
import com.simplelife.simplelife.mapper.CommentMapper;
import com.simplelife.simplelife.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author simplelife
 * @since 2021-06-16
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
