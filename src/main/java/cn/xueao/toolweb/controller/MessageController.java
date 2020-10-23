package cn.xueao.toolweb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xueao.toolweb.pojo.Message;
import cn.xueao.toolweb.service.MessageService;

@Controller
@RequestMapping("")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/leavingMessage")
	public String leavingMessage(Model model, String content) {
		Message m = new Message();
		m.setUid(null);
		m.setContent(content);
		m.setDate(new Date());
		messageService.add(m);
				
		return "redirect:/forehome";
	}
}
