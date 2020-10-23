package cn.xueao.toolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xueao.toolweb.mapper.BookmarkMapper;
import cn.xueao.toolweb.pojo.Bookmark;
import cn.xueao.toolweb.pojo.BookmarkExample;
import cn.xueao.toolweb.service.BookmarkService;

@Service
public class BookmarkServiceImpl implements BookmarkService{
	
	@Autowired
	BookmarkMapper bookmarkMapper;

	@Override
	public void add(Bookmark b) {
		bookmarkMapper.insert(b);
	}

	@Override
	public void delete(Bookmark b) {
		bookmarkMapper.deleteByPrimaryKey(b.getId());
	}

	@Override
	public void update(Bookmark b) {
		bookmarkMapper.updateByPrimaryKeySelective(b);
	}

	@Override
	public List<Bookmark> list(long cid) {
		BookmarkExample example = new BookmarkExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("sn asc");
		return bookmarkMapper.selectByExample(example);
	}

	 

}
