package com.simplelife.simplelife.Blogvo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class BlogDetail {
    private Long id;

    private String title;

    private String content;

    private Date createTime;

    private String typeName;
}
