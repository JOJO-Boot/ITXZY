package com.service.imp;

import com.dao.LeaveWordMapper;
import com.pojo.LeaveWord;
import com.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveWordServiceImp implements LeaveWordService {

    @Autowired
    private LeaveWordMapper leaveWordMapper;

    @Override
    public Integer deleteById(Long id) {
        return leaveWordMapper.deleteById(id);
    }

    @Override
    public LeaveWord findById(Long id) {
        return leaveWordMapper.findById(id);
    }
}
