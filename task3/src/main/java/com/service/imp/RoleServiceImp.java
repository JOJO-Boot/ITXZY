package com.service.imp;

import com.dao.RoleMapper;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public Integer deleteById(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public Role findById(Long id) {
        return roleMapper.findById(id);
    }
}
