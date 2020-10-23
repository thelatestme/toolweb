package cn.xueao.toolweb.service;

import java.util.List;
import cn.xueao.toolweb.pojo.Message;

public interface MessageService {
	
	public void add(Message message);
	
	public void delete(Message message);
	
	public List<Message> list();
	
}
