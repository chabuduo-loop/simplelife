package com.simplelife.simplelife.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplelife.simplelife.Blogvo.BlogDetail;
import com.simplelife.simplelife.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author simplelife
 * @since 2021-06-16
 */
@Service
public interface BlogService extends IService<Blog> {
    BlogDetail getBlogDetail(Long id);

    IPage<BlogDetail> getAllBlogDetail(Page<BlogDetail> page);

}
