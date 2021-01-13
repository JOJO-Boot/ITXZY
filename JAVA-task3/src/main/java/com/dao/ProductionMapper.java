package com.dao;

import com.pojo.Production;

public interface ProductionMapper {

    public Integer insertProduction(Production production);

    public Integer deleteById(Long id);

    public Integer updateProduction(Production production);

    Production findById(Long id);
}
