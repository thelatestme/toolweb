package cn.xueao.toolweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xueao.toolweb.pojo.Bookmark;
import cn.xueao.toolweb.service.BookmarkCategoryService;
import cn.xueao.toolweb.service.BookmarkService;

@Controller
@RequestMapping("")
public class BookmarkController {
	@Autowired
	BookmarkCategoryService bookmarkCategoryService;
	@Autowired
	BookmarkService bookmarkService;
	
	@RequestMapping("/addBookmark")
	@ResponseBody
	public String addBookmark(Model model,Bookmark bookmark) {
		//bookmarkService.add(bookmark);
		return "success";
	}
}
