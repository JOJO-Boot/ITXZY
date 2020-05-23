package com.itxzy.mapper;

import com.itxzy.bean.Student;

import java.util.List;


public interface IStudentMapper {
    /**
     * 增加
     */
    void insertStudent(Student student);

    /**
     * 删除
     */
    void deleteStudent(Integer id);

    /**
     * 修改
     */
    void updateStudent( Student student);

    /**
     * 通过名字模糊查询
     */
    List<Student> findStudentByName(String name);

    /**
     * 通过id查询
     */
    Student findStudentById(Integer userId);

}
