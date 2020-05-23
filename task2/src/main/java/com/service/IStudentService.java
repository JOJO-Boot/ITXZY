package com.service;

import com.bean.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 增加
     * @param student
     * @return
     */
     void insertStudent(Student student);

    /**
     * 删除
     * @return
     */
     void deleteStudent(Integer id);

    /**
     * 修改
     * @param
     * @return
     */
     void updateStudent(Student student);

    /**
     * 通过名字模糊查询
     */
    List<Student> findStudentByName(String name);

    /**
     * 通过id查询
     */
    Student findStudentById(Integer id);

    /**
     * 查询所有
     */
    List<Student> findAll();
}
