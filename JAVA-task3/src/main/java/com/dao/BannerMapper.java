package com.dao;

import com.pojo.Banner;

public interface BannerMapper {

    public Integer insertBanner(Banner banner);

    public Integer deleteById(Long id);

    public Integer updateBanner(Banner banner);

    Banner findById(Long id);
}