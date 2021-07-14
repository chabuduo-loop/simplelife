package com.simplelife.simplelife.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplelife.simplelife.Blogvo.BlogCreateTime;
import com.simplelife.simplelife.Blogvo.BlogDetail;
import com.simplelife.simplelife.entity.Blog;
import com.simplelife.simplelife.entity.Type;
import com.simplelife.simplelife.mapper.BlogMapper;

import com.simplelife.simplelife.mapper.TypeMapper;
import com.simplelife.simplelife.service.BlogService;
import com.simplelife.simplelife.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author simplelife
 * @since 2021-06-16
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogService blogService;
    @Autowired
    TypeMapper typeMapper;
    @GetMapping
    public String allBlog(Model model){
        IPage page = new Page(1, 5);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_Time");
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));
        model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
        return "blogList";
    }
    @PostMapping
    public String searchBlog(@RequestParam("title") String title, Model model){
        IPage page = new Page(1, 5);
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));
        model.addAttribute("blog",blogMapper.blogSearch((Page) page,title));
        return "blogList";
    }

    @GetMapping("/{pagenum}")
    public String Bloglist(@PathVariable Long pagenum, Model model){
        IPage page = new Page(pagenum,5);
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));
        model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
        return "blogList";

    }
    @GetMapping(value={"/type/{typename}/{pagenum}","/type/{typename}"})
    public String blogType(@PathVariable(value = "pagenum",required = false) Long pagenum,
                           @PathVariable String typename, Model model){
        IPage page = new Page(pagenum = 1L,5);
        model.addAttribute("blog",blogMapper.getBlogListByType((Page) page,typename));
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));

        return "blogListByType";
    }
    @GetMapping("/detail/{blogid}")
    public String blogPublish(@PathVariable Long blogid ,Model model){
        BlogDetail blogDetail = blogService.getBlogDetail(blogid);
        model.addAttribute("Blog",blogDetail);
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));
        return "blogDetail";
    }


    @GetMapping("/date/{createTime}")
    public String createTime(@PathVariable String createTime, Model model) {
        IPage page = new Page(1, 5);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM");
        Date date = null;
        try {
            date = sdf.parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("blogs",blogMapper.getBlogIdCreateTime());
        model.addAttribute("Type",typeMapper.selectList(null));
        model.addAttribute("blog",blogMapper.getBlogListByCreateTime((Page)page,date));
        return "blogListByCreateTime";
    }
    @GetMapping("test/chabuduo")
    public String chabudu(Model model){
        IPage page = new Page(1,5);
        model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
        return "test";
    }
}
