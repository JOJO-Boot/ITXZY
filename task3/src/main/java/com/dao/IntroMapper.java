package com.dao;

import com.pojo.Intro;

public interface IntroMapper {
    public Integer insertIntro(Intro intro);

    public Integer deleteById(Long id);

    public Integer updateIntro(Intro intro);

    Intro findById(Long id);
}
