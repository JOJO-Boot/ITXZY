package com.dao;

import com.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectByHot(@Param("hot") Integer hot);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}