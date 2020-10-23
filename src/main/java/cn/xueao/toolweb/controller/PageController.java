package cn.xueao.toolweb.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.xueao.toolweb.pojo.Bookmark;
import cn.xueao.toolweb.pojo.BookmarkCategory;
import cn.xueao.toolweb.pojo.User;
import cn.xueao.toolweb.service.BookmarkCategoryService;
import cn.xueao.toolweb.service.BookmarkService;
import cn.xueao.toolweb.service.PictureService;
import cn.xueao.toolweb.service.UserService;

@Controller
@RequestMapping("")
public class PageController {
	
	@Autowired BookmarkCategoryService bookmarkCategoryService;
	@Autowired BookmarkService bookmarkServicer;
	@Autowired PictureService pictureService;
	@Autowired UserService userService;
	
	@RequestMapping("/forehome")
	public String forehome(Model model) {
		String account = "a202297";
		String password = "a3758562";
		if (!userService.isAccountExist(account)) {
			User user = new User();
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			String encodedPassword = new SimpleHash("md5", password, salt, 2).toString();
			user.setAccount_number(account);
			user.setPassword(encodedPassword);
			user.setSalt(salt);
			user.setName("站长");
			userService.add(user);
		}
		//自动登录
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		subject.login(token);
		Session session = subject.getSession();
		session.setAttribute("subject", subject);
		User user = userService.getByAccount(account);
		session.setAttribute("user", user);
		System.out.println(user.getName());
		return "fore/home";
	}
	
	@RequestMapping("/forebookmark")
	public String forebookmark(Model model, long uid,
			@RequestParam(defaultValue = "1")long cid) {
		
		List<BookmarkCategory> bCategories = bookmarkCategoryService.list(uid);
		List<Bookmark> bookmarks = bookmarkServicer.list(cid);
		long sn = bookmarks.size()+1;
		System.out.println("当前书签数量"+bookmarks.size());
		model.addAttribute("bCategories", bCategories);
		model.addAttribute("bookmarks", bookmarks);
		model.addAttribute("cid", cid);
		model.addAttribute("sn", sn);
		System.out.println("当前序号"+sn);
		return "fore/bookmark";
	}
}
