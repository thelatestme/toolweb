package cn.xueao.toolweb.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import cn.xueao.toolweb.pojo.User;
import cn.xueao.toolweb.service.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/loginAjax", method = RequestMethod.POST)
	@ResponseBody
	public String login(Model model, @RequestParam("account") String account,
			@RequestParam("password") String password) {
		account = HtmlUtils.htmlEscape(account);  //转义
		password = HtmlUtils.htmlEscape(password);
		System.out.println(account+" "+password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		try {
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("subject", subject);
			
			User user = userService.getByAccount(account);
			session.setAttribute("user", user);
			System.out.println(user.getName());
			
			return "success";

		} catch (UnknownAccountException e) {
			
			return "unkonw account";
		} catch (IncorrectCredentialsException e) {
			
			return "wrong password";
		}

	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.GET)
	@ResponseBody
	public String checklogin(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		String user = (String) subject.getPrincipal();
		if (user != null) {
			return "success";
		}
		return "fail";
	}

}
