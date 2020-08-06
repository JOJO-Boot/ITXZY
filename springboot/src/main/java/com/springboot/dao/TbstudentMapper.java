package com.springboot.dao;

import com.springboot.pojo.Tbstudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TbstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tbstudent record);

    int insertSelective(Tbstudent record);

    Tbstudent selectByPrimaryKey(Integer id);

    List<Tbstudent>selectAll();

    int updateByPrimaryKeySelective(Tbstudent record);

    int updateByPrimaryKey(Tbstudent record);
}