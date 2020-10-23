package cn.xueao.toolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xueao.toolweb.mapper.MessageMapper;
import cn.xueao.toolweb.pojo.Message;
import cn.xueao.toolweb.pojo.MessageExample;
import cn.xueao.toolweb.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageMapper messageMapper;
	
	@Override
	public void add(Message message) {
		messageMapper.insert(message);
	}

	@Override
	public void delete(Message message) {
		messageMapper.deleteByPrimaryKey(message.getId());
	}

	@Override
	public List<Message> list() {
		MessageExample example = new MessageExample();
		example.setOrderByClause("id desc");
		return messageMapper.selectByExample(example);
	}

}
