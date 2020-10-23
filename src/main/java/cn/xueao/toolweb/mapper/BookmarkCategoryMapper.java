package cn.xueao.toolweb.mapper;

import cn.xueao.toolweb.pojo.BookmarkCategory;
import cn.xueao.toolweb.pojo.BookmarkCategoryExample;
import java.util.List;

public interface BookmarkCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookmarkCategory record);

    int insertSelective(BookmarkCategory record);

    List<BookmarkCategory> selectByExample(BookmarkCategoryExample example);

    BookmarkCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookmarkCategory record);

    int updateByPrimaryKey(BookmarkCategory record);
}