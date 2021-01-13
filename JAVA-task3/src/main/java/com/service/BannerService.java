package com.service;

import com.pojo.Banner;

public interface BannerService {
    public Integer insertBanner(Banner banner);

    public Integer deleteById(Long id);

    public Integer updateBanner(Banner banner);

    public Banner findById(Long id);
}
