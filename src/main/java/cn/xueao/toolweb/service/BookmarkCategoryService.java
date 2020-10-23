package cn.xueao.toolweb.service;

import java.util.List;

import cn.xueao.toolweb.pojo.BookmarkCategory;

public interface BookmarkCategoryService {
	
	public void add(BookmarkCategory category);
	
	public void delete(BookmarkCategory category);
	
	public void update(BookmarkCategory category);
	
	public List<BookmarkCategory> list(long uid);
}
