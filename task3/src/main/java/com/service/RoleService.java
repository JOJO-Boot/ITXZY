package com.service;

import com.pojo.Role;

public interface RoleService {
    public Integer insertRole(Role role);

    public Integer deleteById(Long id);

    public Integer updateRole(Role role);

    Role findById(Long id);
}
