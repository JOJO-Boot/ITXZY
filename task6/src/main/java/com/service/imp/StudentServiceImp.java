package com.service.imp;

import com.dao.StudentMapper;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MemcachedUtil;
import util.RedisUtil;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    MemcachedUtil memcachedUtil = new MemcachedUtil();
    RedisUtil redisUtil = new RedisUtil();

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

    //Redis
    @Override
    public Student selectByPrimaryKey(Long id) {
        if(redisUtil.get("key2") != null){
            System.out.println("redis获取优秀学生");
        }else {
            redisUtil.set("key2",studentMapper.selectByPrimaryKey((long) 1).getName());
            System.out.println("redis添加学生");
        }
        return studentMapper.selectByPrimaryKey(id);
    }

    //Memcached
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
