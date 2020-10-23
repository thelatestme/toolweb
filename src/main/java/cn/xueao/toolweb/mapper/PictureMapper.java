package cn.xueao.toolweb.mapper;

import cn.xueao.toolweb.pojo.Picture;
import cn.xueao.toolweb.pojo.PictureExample;
import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    Picture selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}