package com.service.imp;

import com.dao.StudentMapper;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MemcachedUtil;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    MemcachedUtil memcachedUtil = new MemcachedUtil();

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectByHot(Integer hot) {
        if (memcachedUtil.get("hot")!= null){
            System.out.println("在缓存中获取优秀学生");
        }else {
            memcachedUtil.set("hot",studentMapper.selectByHot(1));
            System.out.println("添加优秀学生到缓存中，返回数据库中的学生");
        }
        return studentMapper.selectByHot(hot);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
