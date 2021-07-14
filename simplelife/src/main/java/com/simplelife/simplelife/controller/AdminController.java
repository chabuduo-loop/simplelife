package com.simplelife.simplelife.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplelife.simplelife.entity.Blog;
import com.simplelife.simplelife.entity.Type;
import com.simplelife.simplelife.entity.User;
import com.simplelife.simplelife.mapper.BlogMapper;
import com.simplelife.simplelife.mapper.TypeMapper;
import com.simplelife.simplelife.mapper.UserMapper;
import com.simplelife.simplelife.service.BlogService;
import com.simplelife.simplelife.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TypeMapper typeMapper;

    @GetMapping("/bloglist")
    public String allBlog(Model model){
        IPage page = new Page(1,10);
        model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
        return "admin/bloglist";
    }
    @GetMapping("/bloglist/{id}")
    public String blogDelete(Model model, @PathVariable Long id ){
        IPage page = new Page(1,10);
        blogMapper.deleteBlog(id);
            model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
        return "admin/bloglist";
    }


    @GetMapping("/publish")
    public String blogPublishpage(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeMapper.selectList(null));
        return "admin/blog-publish";
    }

    @GetMapping("/publish/{id}")
    public String blogPublishbyid(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogMapper.selectById(id));
        model.addAttribute("types",typeMapper.selectList(null));
        return "admin/blog-update";
    }

    @PostMapping("/publish")
    public String post(Blog blog, RedirectAttributes attributes) {
        LocalDateTime date = LocalDateTime.now();
        blog.setCreateTime(date);
        blog.setAppreciation(true);
        blog.setCommentabled(true);
        blog.setPublished(true);
        blog.setShareStatement(true);
        blog.setRecommend(true);
        if (blog.getId() == null) {
            blogMapper.insert(blog);
        } else {
            blogMapper.updateById(blog);
        }
        return "admin/blog-publish";
    }




    @GetMapping("/login")
    public String blogLogin(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session,
                            RedirectAttributes attributes,Model model){

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username",username).eq("password",password));
        if(user != null){
            session.setAttribute("user",user);
            IPage page = new Page(1,10);
            model.addAttribute("blog",blogMapper.getAllBlogDetail((Page) page));
            return "admin/bloglist";
        }else{
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:login";
        }

    }

    @GetMapping("/typelist")
    public String typeList(RedirectAttributes attributes,Model model){
        attributes.addFlashAttribute("message","1");
        return "admin/typelist";
    }

    @PostMapping("/typelist")
    public String addtype(@RequestParam("typename") String typename,RedirectAttributes attributes
                         ){
        Type type = typeMapper.selectOne(new QueryWrapper<Type>().eq("name",typename));
        if(type == null){
            Type type1 = new Type();
            type1.setName(typename);
            typeMapper.insert(type1);
            attributes.addFlashAttribute("message", "添加博客类型成功");
            return "redirect:typelist";
        }else{
            attributes.addFlashAttribute("message", "添加博客类型失败，博客类型已存在");
            return "redirect:typelist";
        }



    }
}

