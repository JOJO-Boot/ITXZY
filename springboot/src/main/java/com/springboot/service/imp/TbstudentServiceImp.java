package com.springboot.service.imp;

import com.springboot.dao.TbstudentMapper;
import com.springboot.pojo.Tbstudent;
import com.springboot.service.TbstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbstudentServiceImp implements TbstudentService {

    @Autowired
    private TbstudentMapper tbstudentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tbstudentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tbstudent record) {
        return tbstudentMapper.insert(record);
    }

    @Override
    public int insertSelective(Tbstudent record) {
        return tbstudentMapper.insertSelective(record);
    }

    @Override
    public Tbstudent selectByPrimaryKey(Integer id) {
        return tbstudentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tbstudent> selectAll() {
        return tbstudentMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Tbstudent record) {
        return tbstudentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tbstudent record) {
        return tbstudentMapper.updateByPrimaryKey(record);
    }
}
