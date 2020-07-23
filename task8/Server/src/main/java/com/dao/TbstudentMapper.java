package com.dao;

import com.pojo.Tbstudent;

import java.util.List;

public interface TbstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tbstudent record);

    int insertSelective(Tbstudent record);

    Tbstudent selectByPrimaryKey(Integer id);

    List<Tbstudent>selectAll();

    int updateByPrimaryKeySelective(Tbstudent record);

    int updateByPrimaryKey(Tbstudent record);
}