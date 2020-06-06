package com.service.imp;

import com.dao.ThemeMapper;
import com.pojo.Theme;
import com.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImp implements ThemeService {
    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public Integer insertTheme(Theme theme) {
        return themeMapper.insertTheme(theme);
    }

    @Override
    public Integer deleteById(Long id) {
        return themeMapper.deleteById(id);
    }

    @Override
    public Integer updateTheme(Theme theme) {
        return themeMapper.updateTheme(theme);
    }

    @Override
    public Theme findById(Long id) {
        return themeMapper.findById(id);
    }
}
