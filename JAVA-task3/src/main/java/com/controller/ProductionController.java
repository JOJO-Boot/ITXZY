package com.controller;

import com.pojo.Production;
import com.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ProductionController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private ProductionService productionService;


    @RequestMapping(value = "/c/prode",method = RequestMethod.POST)
    public String insert(Production production, Model model){
        logger.info("production is " + production);
        if (null == production){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try{
            productionService.insertProduction(production);
            model.addAttribute("code","0");
            model.addAttribute("message","success");
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            model.addAttribute("code","-1");
            model.addAttribute("message","error");
        }
        return "success";
    }


    @RequestMapping(value = "/c/prode/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete theme id is " + id);
        try{
            productionService.deleteById(id);
            model.addAttribute("code","0");
            model.addAttribute("message","success");
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            model.addAttribute("code","-1");
            model.addAttribute("message","error");
        }
        return "success";
    }

    @RequestMapping(value = "/c/prode/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                         Long sampleReelsId,
                         String sampleReelsName,
                         Long themeId,
                         String themeName,
                         String name,
                         String content,
                         Long createAt,
                         Long updateAt,
                         String updateBy,
                         Model model){
        logger.info("sampleReelsId:" + sampleReelsId
                + "sampleReelsName is:" +sampleReelsName
                + "themeId is:" + themeId
                +"themeName is:" + themeName
                + "name is:" + name
                +"content is :"+ content
                +"createAt is:" + createAt
                +"updateAt is:" + updateAt
                +"updateBy is " + updateBy);
        if(null == name){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try {
            Production production = productionService.findById(id);
            logger.info("production is " + production);
            production.setSampleReelsId(sampleReelsId);
            production.setSampleReelsName(sampleReelsName);
            production.setThemeId(sampleReelsId);
            production.setThemeName(sampleReelsName);
            production.setName(name);
            production.setContent(content);
            production.setCreateAt(createAt);
            production.setUpdateAt(updateAt);
            production.setUpdateBy(updateBy);
            productionService.updateProduction(production);

            model.addAttribute("code","0");
            model.addAttribute("message","success");
        }catch (Exception e){
            e.getMessage();
            logger.error(e.getMessage());
            model.addAttribute("code","-1");
            model.addAttribute("message","error");
        }
        return "success";
    }

    @RequestMapping(value = "/c/prode/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        Production production = productionService.findById(id);
        model.addAttribute("production",production);
        return "production";
    }
}
