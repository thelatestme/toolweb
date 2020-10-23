package cn.xueao.toolweb.mapper;

import cn.xueao.toolweb.pojo.Bookmark;
import cn.xueao.toolweb.pojo.BookmarkExample;
import java.util.List;

public interface BookmarkMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bookmark record);

    int insertSelective(Bookmark record);

    List<Bookmark> selectByExample(BookmarkExample example);

    Bookmark selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bookmark record);

    int updateByPrimaryKey(Bookmark record);
    
    int count(long cid);
}