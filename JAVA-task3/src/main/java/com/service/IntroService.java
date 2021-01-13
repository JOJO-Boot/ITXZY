package com.service;

import com.pojo.Intro;

public interface IntroService {
    public Integer insertIntro(Intro intro);

    public Integer deleteById(Long id);

    public Integer updateIntro(Intro intro);

    Intro findById(Long id);
}
