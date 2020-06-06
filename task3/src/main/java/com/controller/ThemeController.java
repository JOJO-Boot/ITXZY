package com.controller;

import com.pojo.Theme;
import com.service.ThemeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ThemeController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private ThemeService themeService;


    @RequestMapping(value = "/c/theme",method = RequestMethod.POST)
    public String insert(Theme theme, Model model){
        logger.info("theme is " + theme);
        if (null == theme){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try{
            themeService.insertTheme(theme);
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


    @RequestMapping(value = "/c/theme/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete theme is " + id);
        try{
            themeService.deleteById(id);
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

    @RequestMapping(value = "/c/theme/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                         Long sampleReelsId,
                         String sampleReelsName,
                         String name,
                         Long createAt,
                         Long updateAt,
                         String updateBy,
                         Model model){
        logger.info("sampleReelsId:" + sampleReelsId
                + "sampleReelsName:" +sampleReelsName
                + "name is:" + name
                +"createAt is:" + createAt
                +"updateAt is:" + updateAt
                +"updateBy is " + updateBy);
        if(null == name){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try {
            Theme theme = themeService.findById(id);
            logger.info("theme is " + theme);
            theme.setSampleReelsId(sampleReelsId);
            theme.setSampleReelsName(sampleReelsName);
            theme.setName(name);
            theme.setCreateAt(createAt);
            theme.setUpdateAt(updateAt);
            theme.setUpdateBy(updateBy);
            themeService.updateTheme(theme);

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

    @RequestMapping(value = "/c/theme/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        Theme theme = themeService.findById(id);
        model.addAttribute("theme",theme);
        return "theme";
    }
}
