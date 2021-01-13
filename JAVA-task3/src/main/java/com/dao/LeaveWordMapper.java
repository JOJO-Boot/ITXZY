package com.dao;

import com.pojo.LeaveWord;

public interface LeaveWordMapper {

    public Integer deleteById(Long id);

    LeaveWord findById(Long id);

}
