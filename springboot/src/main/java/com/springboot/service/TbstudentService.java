package com.springboot.service;

import com.springboot.pojo.Tbstudent;

import java.util.List;

public interface TbstudentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Tbstudent record);

    int insertSelective(Tbstudent record);

    Tbstudent selectByPrimaryKey(Integer id);

    List<Tbstudent> selectAll();

    int updateByPrimaryKeySelective(Tbstudent record);

    int updateByPrimaryKey(Tbstudent record);
}
