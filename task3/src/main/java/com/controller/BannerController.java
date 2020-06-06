package com.controller;

import com.pojo.Banner;
import com.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;

@Controller
public class BannerController {
   Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private BannerService bannerService;
    //增加
    @RequestMapping(value = "/c/banner",method = RequestMethod.POST)
    public String insert(Banner banner,Model model){
        logger.info("banner is : "+ banner);
        try{
            bannerService.insertBanner(banner);
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

    //删除
    @RequestMapping(value = "/c/banner/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") Long id,Model model){
        logger.info("delete banner id is :"+ id);
        try{
            bannerService.deleteById(id);
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

    //更改
    @RequestMapping(value = "/c/banner/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                        String url,
                         Model model){
        try {
            logger.info("url is : "+ url);
            Banner banner = bannerService.findById(id);
            logger.info("banner is " + banner);
            banner.setUrl(url);
            bannerService.updateBanner(banner);
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

    //id查询
    @RequestMapping(value = "/c/banner/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id, Model model){
        Banner banner = bannerService.findById(id);
        model.addAttribute("banner",banner);
        return "banner";
    }
}
