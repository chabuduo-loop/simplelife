package com.simplelife.simplelife.service.impl;

import com.simplelife.simplelife.entity.Message;
import com.simplelife.simplelife.mapper.MessageMapper;
import com.simplelife.simplelife.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
