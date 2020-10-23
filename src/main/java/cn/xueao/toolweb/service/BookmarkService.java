package cn.xueao.toolweb.service;

import java.util.List;

import cn.xueao.toolweb.pojo.Bookmark;

public interface BookmarkService {

	public void add(Bookmark b);
	
	public void delete(Bookmark b);
	
	public void update(Bookmark b);
	
	public List<Bookmark> list(long cid);
}
