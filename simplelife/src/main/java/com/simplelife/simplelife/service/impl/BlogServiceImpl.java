package com.simplelife.simplelife.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplelife.simplelife.Blogvo.BlogDetail;
import com.simplelife.simplelife.entity.Blog;
import com.simplelife.simplelife.mapper.BlogMapper;
import com.simplelife.simplelife.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author simplelife
 * @since 2021-06-16
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public BlogDetail getBlogDetail(Long id){
        return  blogMapper.getBlogDetail(id);
    }

    @Override
    public IPage<BlogDetail> getAllBlogDetail(Page<BlogDetail> page){
        return blogMapper.getAllBlogDetail(page);

    }
}
