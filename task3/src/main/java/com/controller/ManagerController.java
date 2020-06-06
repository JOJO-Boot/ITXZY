package com.controller;

import com.pojo.Intro;
import com.pojo.Manager;
import com.service.IntroService;
import com.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class ManagerController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private ManagerService managerService;
    //增加
    @RequestMapping(value = "/c/manager",method = RequestMethod.POST)
    public String insert(Manager manager, Model model){
        logger.info("manager is " + manager);
        try{
            managerService.insertManager(manager);
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


    @RequestMapping(value = "/c/manager/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete intro id is " + id);
        try{
            managerService.deleteById(id);
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

    @RequestMapping(value = "/c/manager/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                         String name,
                         String password,
                         Long lastLogAt,
                         Model model){
        logger.info("name is:" + name
                +"password is:" + password
                +"lastLogAt is:" + lastLogAt);
        try {
            Manager manager = managerService.findById(id);
            logger.info("manager is " + manager);
            manager.setName(name);
            manager.setPassword(password);
            manager.setLastLogAt(lastLogAt);
            managerService.updateManager(manager);

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

    @RequestMapping(value = "/c/manager/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        Manager manager = managerService.findById(id);
        model.addAttribute("manager",manager);
        return "manager";
    }
}
