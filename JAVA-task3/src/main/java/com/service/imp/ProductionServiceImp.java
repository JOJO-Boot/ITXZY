package com.service.imp;

import com.dao.ProductionMapper;
import com.pojo.Production;
import com.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionServiceImp implements ProductionService {
    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public Integer insertProduction(Production production) {
        return productionMapper.insertProduction(production);
    }

    @Override
    public Integer deleteById(Long id) {
        return productionMapper.deleteById(id);
    }

    @Override
    public Integer updateProduction(Production production) {
        return productionMapper.updateProduction(production);
    }

    @Override
    public Production findById(Long id) {
        return productionMapper.findById(id);
    }
}
