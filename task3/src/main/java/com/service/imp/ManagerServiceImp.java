package com.service.imp;

import com.dao.ManagerMapper;
import com.pojo.Manager;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Integer insertManager(Manager manager) {
        return managerMapper.insertManager(manager);
    }

    @Override
    public Integer deleteById(Long id) {
        return managerMapper.deleteById(id);
    }

    @Override
    public Integer updateManager(Manager manager) {
        return managerMapper.updateManager(manager);
    }

    @Override
    public Manager findById(Long id) {
        return managerMapper.findById(id);
    }
}
