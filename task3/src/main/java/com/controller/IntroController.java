package com.controller;

import com.pojo.Intro;
import com.service.IntroService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class IntroController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private IntroService introService;
    //增加
    @RequestMapping(value = "/c/intro",method = RequestMethod.POST)
    public String insert(Intro intro, Model model){
        logger.info("intro is " + intro);
        try{
            introService.insertIntro(intro);
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


    @RequestMapping(value = "/c/intro/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete intro id is " + id);
        try{
            introService.deleteById(id);
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

    @RequestMapping(value = "/c/intro/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                         String name,
                         Long createAt,
                         Long updateAt,
                         String updateBy,
                         Model model){
        logger.info("name is:" + name
                +"createAt is:" + createAt
                +"updateAt is:" + updateAt
                +"updateBy is " + updateBy);
        if(null == name){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try {
            Intro intro = introService.findById(id);
            logger.info("intro is " + intro);
            intro.setName(name);
            intro.setCreateAt(createAt);
            intro.setUpdateAt(updateAt);
            intro.setUpdateBy(updateBy);
            introService.updateIntro(intro);

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

    @RequestMapping(value = "/c/intro/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        Intro intro = introService.findById(id);
        model.addAttribute("intro",intro);
        return "intro";
    }
}
