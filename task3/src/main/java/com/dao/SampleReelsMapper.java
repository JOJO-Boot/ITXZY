package com.dao;

import com.pojo.SampleReels;

public interface SampleReelsMapper {

    public Integer insertSampleReels(SampleReels sampleReels);

    public Integer deleteById(Long id);

    public Integer updateSampleReels(SampleReels sampleReels);

    SampleReels findById(Long id);
}
