package com.controller;

import com.pojo.Role;
import com.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RoleController {
    Logger logger = Logger.getLogger(BannerController.class);
    @Resource
    private RoleService roleService;


    @RequestMapping(value = "/c/role",method = RequestMethod.POST)
    public String insert(Role role, Model model){
        logger.info("role is " + role);
        if (null == role){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try{
            roleService.insertRole(role);
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


    @RequestMapping(value = "/c/role/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model){
        logger.info("delete role id is " + id);
        try{
            roleService.deleteById(id);
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

    @RequestMapping(value = "/c/role/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Long id,
                         String name,
                         String jurisdiction,
                         Long createAt,
                         Long updateAt,
                         String updateBy,
                         Long lastLogAt,
                         Model model){
        logger.info("name is:" + name
                + "jurisdiction is:" + jurisdiction
                +"createAt is:" + createAt
                +"updateAt is:" + updateAt
                +"updateBy is " + updateBy
                +"lastLogAt is:" + lastLogAt);
        if(null == name){
            model.addAttribute("code","-1");
            model.addAttribute("message","参数没有传");
            return "success";
        }
        try {
            Role role = roleService.findById(id);
            logger.info("role is " + role);
            role.setName(name);
            role.setJurisdiction(jurisdiction);
            role.setCreateAt(createAt);
            role.setUpdateAt(updateAt);
            role.setUpdateBy(updateBy);
            role.setLastLogAt(lastLogAt);
            roleService.updateRole(role);

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

    @RequestMapping(value = "/c/role/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id,Model model){
        Role role = roleService.findById(id);
        model.addAttribute("role",role);
        return "role";
    }
}
