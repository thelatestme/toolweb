package cn.xueao.toolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xueao.toolweb.mapper.BookmarkCategoryMapper;
import cn.xueao.toolweb.mapper.BookmarkMapper;
import cn.xueao.toolweb.pojo.BookmarkCategory;
import cn.xueao.toolweb.pojo.BookmarkCategoryExample;
import cn.xueao.toolweb.service.BookmarkCategoryService;

@Service
public class BookmarkCategoryServiceImpl implements BookmarkCategoryService{

	@Autowired
	BookmarkCategoryMapper bCategoryMapper;
	@Autowired
	BookmarkMapper bookmarkMapper;
	
	@Override
	public void add(BookmarkCategory category) {
		bCategoryMapper.insert(category);
	}

	@Override
	public void delete(BookmarkCategory category) {
		bCategoryMapper.deleteByPrimaryKey(category.getId());
	}

	@Override
	public void update(BookmarkCategory category) {
		bCategoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public List<BookmarkCategory> list(long uid) {
		BookmarkCategoryExample example = new BookmarkCategoryExample();
		example.createCriteria().andUidEqualTo(uid);
		example.setOrderByClause("id asc");
		List<BookmarkCategory> bCategories = bCategoryMapper.selectByExample(example);
		if (bCategories.isEmpty()) {       //用户书签分类为空 则创建默认分组
			BookmarkCategory defaultCategory = new BookmarkCategory();
			defaultCategory.setName("默认分组");
			defaultCategory.setUid(uid);
			add(defaultCategory);
			bCategories.add(defaultCategory);
		}
		fillAmount(bCategories);
		
		return bCategories;
	}
	
	public void fillAmount(BookmarkCategory bCategory) {
		int amount = bookmarkMapper.count(bCategory.getId());
		bCategory.setAmount(amount);
	}
	
	public void fillAmount(List<BookmarkCategory> bCategories) {
		for (BookmarkCategory bmarkCategory : bCategories) {
			fillAmount(bmarkCategory);
		}
	}

}
