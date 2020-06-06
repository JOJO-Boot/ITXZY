package com.controller;

import com.pojo.SampleReels;
import com.service.SampleReelsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class SampleReelsController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private SampleReelsService sampleReelsService;


    @RequestMapping(value = "/c/sare",method = RequestMethod.POST)
    public String insert(SampleReels sampleReels, Model model){
        logger.info("sampleReels is " + sampleReels);
        if (null == sampleReels){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try{
            sampleReelsService.insertSampleReels(sampleReels);
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


    @RequestMapping(value = "/c/sare/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete sare id is " + id);
        try{
            sampleReelsService.deleteById(id);
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

    @RequestMapping(value = "/c/sare/{id}",method = RequestMethod.PUT)
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
            SampleReels sampleReels = sampleReelsService.findById(id);
            logger.info("sampleReels is " + sampleReels);
            sampleReels.setName(name);
            sampleReels.setCreateAt(createAt);
            sampleReels.setUpdateAt(updateAt);
            sampleReels.setUpdateBy(updateBy);
            sampleReelsService.updateSampleReels(sampleReels);

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

    @RequestMapping(value = "/c/sare/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        SampleReels sampleReels = sampleReelsService.findById(id);
        model.addAttribute("sampleReels",sampleReels);
        return "sampleReels";
    }
}
