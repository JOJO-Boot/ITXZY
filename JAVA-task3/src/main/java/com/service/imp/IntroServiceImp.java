package com.service.imp;

import com.dao.IntroMapper;
import com.pojo.Intro;
import com.service.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntroServiceImp implements IntroService {

    @Autowired
    private IntroMapper introMapper;

    @Override
    public Integer insertIntro(Intro intro) {
        return introMapper.insertIntro(intro) ;
    }

    @Override
    public Integer deleteById(Long id) {
        return introMapper.deleteById(id);
    }

    @Override
    public Integer updateIntro(Intro intro) {
        return introMapper.updateIntro(intro);
    }

    @Override
    public Intro findById(Long id) {
        return introMapper.findById(id);
    }
}
