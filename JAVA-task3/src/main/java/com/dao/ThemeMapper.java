package com.dao;

import com.pojo.Theme;

public interface ThemeMapper {

    public Integer insertTheme(Theme theme);

    public Integer deleteById(Long id);

    public Integer updateTheme(Theme theme);

    Theme findById(Long id);
}
