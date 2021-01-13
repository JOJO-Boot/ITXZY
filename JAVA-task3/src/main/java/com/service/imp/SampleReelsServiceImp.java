package com.service.imp;

import com.dao.SampleReelsMapper;
import com.pojo.SampleReels;
import com.service.SampleReelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleReelsServiceImp implements SampleReelsService {

    @Autowired
    private SampleReelsMapper sampleReelsMapper;

    @Override
    public Integer insertSampleReels(SampleReels sampleReels) {
        return sampleReelsMapper.insertSampleReels(sampleReels);
    }

    @Override
    public Integer deleteById(Long id) {
        return sampleReelsMapper.deleteById(id);
    }

    @Override
    public Integer updateSampleReels(SampleReels sampleReels) {
        return sampleReelsMapper.updateSampleReels(sampleReels);
    }

    @Override
    public SampleReels findById(Long id) {
        return sampleReelsMapper.findById(id);
    }
}
