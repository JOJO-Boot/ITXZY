package com.service.imp;

import com.dao.BannerMapper;
import com.pojo.Banner;
import com.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImp implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Integer insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }

    @Override
    public Integer deleteById(Long id) {
        return bannerMapper.deleteById(id);
    }

    @Override
    public Integer updateBanner(Banner banner) {
        return bannerMapper.updateBanner(banner);
    }

    @Override
    public Banner findById(Long id) {
        return bannerMapper.findById(id);
    }
}
