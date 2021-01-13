package com.controller;

import com.pojo.LeaveWord;
import com.service.LeaveWordService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LeaveWordController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private LeaveWordService leaveWordService;

    @RequestMapping(value = "/c/word/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete word id is " + id);
        try{
            leaveWordService.deleteById(id);
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

    @RequestMapping(value = "/c/word/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        LeaveWord leaveWord =leaveWordService.findById(id);
        model.addAttribute("leaveWord",leaveWord);
        return "leaveWord";
    }
}
