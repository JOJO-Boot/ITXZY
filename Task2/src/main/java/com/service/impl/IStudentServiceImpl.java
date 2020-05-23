package com.service.impl;


import com.bean.Student;
import com.mapper.IStudentMapper;
import com.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapper iStudentMapper;
//使用強制注入需要 getter and setter
    public IStudentMapper getiStudentMapper() {
        return iStudentMapper;
    }

    public void setiStudentMapper(IStudentMapper iStudentMapper) {
        this.iStudentMapper = iStudentMapper;
    }



    @Override
    public void insertStudent(Student student) {
        iStudentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        iStudentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentMapper.updateStudent(student);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return iStudentMapper.findStudentByName(name);
    }

    @Override
    public Student findStudentById(Integer id) {
        return iStudentMapper.findStudentById(id);
    }

    @Override
    public List<Student> findAll(){
        return iStudentMapper.findAll();
    }
}

