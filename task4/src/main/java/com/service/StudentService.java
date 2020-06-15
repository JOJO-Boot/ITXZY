package com.service;

import com.pojo.Student;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectByHot(Long hot);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
