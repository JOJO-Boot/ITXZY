package com.service;

import com.pojo.LeaveWord;

public interface LeaveWordService {

    public Integer deleteById(Long id);

    LeaveWord findById(Long id);
}
