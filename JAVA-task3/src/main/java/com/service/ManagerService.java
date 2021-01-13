package com.service;

import com.pojo.Manager;

public interface ManagerService {
    public Integer insertManager(Manager manager);

    public Integer deleteById(Long id);

    public Integer updateManager(Manager manager);

    Manager findById(Long id);
}
