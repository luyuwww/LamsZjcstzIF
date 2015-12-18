package com.lams.dao.mapper;

import java.util.List;

import com.lams.dao.BaseDao;
import com.lams.pojo.SQzh;
import com.lams.pojo.SQzhExample;
import org.apache.ibatis.annotations.Param;

public interface SQzhMapper  extends BaseDao{
    int countByExample(SQzhExample example);

    int deleteByExample(SQzhExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(SQzh record);

    int insertSelective(SQzh record);

    List<SQzh> selectByExample(SQzhExample example);

    SQzh selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") SQzh record, @Param("example") SQzhExample example);

    int updateByExample(@Param("record") SQzh record, @Param("example") SQzhExample example);

    int updateByPrimaryKeySelective(SQzh record);

    int updateByPrimaryKey(SQzh record);
}