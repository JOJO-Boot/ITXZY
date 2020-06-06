package com.service;

import com.pojo.SampleReels;

public interface SampleReelsService {

    public Integer insertSampleReels(SampleReels sampleReels);

    public Integer deleteById(Long id);

    public Integer updateSampleReels(SampleReels sampleReels);

    SampleReels findById(Long id);
}
