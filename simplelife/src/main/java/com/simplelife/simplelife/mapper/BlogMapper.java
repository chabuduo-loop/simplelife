package com.simplelife.simplelife.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplelife.simplelife.Blogvo.BlogDetail;
import com.simplelife.simplelife.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author simplelife
 * @since 2021-06-16
 */

public interface BlogMapper extends BaseMapper<Blog> {

    BlogDetail getBlogDetail(Long id);
    List<BlogDetail> getBlogIdCreateTime();
    IPage<BlogDetail> getAllBlogDetail(Page page);
    IPage<BlogDetail> blogSearch(Page page,String title);
    IPage<BlogDetail> getBlogListByType(Page page,String typename);
    IPage<BlogDetail> getBlogListByCreateTime(Page page, Date date);
    void deleteBlog(Long id);


}
