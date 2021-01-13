package com.controller;

import com.bean.Student;
import com.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping(value = "/student")
public class StudentController {
    //导入日志
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Resource(name = "studentService")
    private IStudentService iStudentService;

    /**
     * 增加
     * 如果没有收到参数，则返回前端
     * 如果收到了参数，那么传递参数到前端
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)

    public String insert(Student student, Model model) {
        //先打日志，方便调试，确认是否有数据传入
        System.out.println("student is : "+student);
        if(null == student){
            model.addAttribute("code", "-1");
            model.addAttribute("message", "参数没有传");
            return "success";
        }
        try {
            iStudentService.insertStudent(student);
//            System.out.println(" 添加成功");
            //往前台传数据，可以传对象，可以传List，通过表达式 ${}可以获取到
            model.addAttribute("code", "0");
            model.addAttribute("message", "success");
        } catch (Exception e) {
            model.addAttribute("code", "-1");
            model.addAttribute("message", "error");
        }
        return "success";
    }


    /**
     * 根据ID更改
     *
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable Integer id,
                         Long createAt,
                         String name,
                         String qq,
                         String type,
                         Long enterAt,
                         String school,
                         Integer onlineId,
                         String link,
                         String desire,
                         String bro,
                         Long  updateAt,
                         String knowFrom,
                         Model model) {
        System.out.println("createAt is :"+createAt
                        + "param name is : "+name
                        + " qq is : "+ qq
                        + " type is : "+type
                        + "enterAt is :"+enterAt
                        +"school is :"+school
                        +"onlineId is :"+onlineId
                        +"lin is :"+link
                        +"desire is :"+desire
                        +"bro is :"+bro
                        +"updateAt is :"+updateAt
                        +"knowFrom is :"+knowFrom);
        if(null == name || null == qq || null == type){
            model.addAttribute("code", "-1");
            model.addAttribute("message", "参数没有穿");
            return "success";
        }
        try {
            Student student = iStudentService.findStudentById(id);
            System.out.println(" student is : "+ student);

            if(null == student){
                model.addAttribute("code", "-1");
                model.addAttribute("message", "对象不存在");
                return "success";
            }
            student.setName(name);
            student.setQq(qq);
            student.setType(type);
            iStudentService.updateStudent(student);
            System.out.println(" result id is : "+2342);
            model.addAttribute("code", "0");
            model.addAttribute("message", "success");
            model.addAttribute("id",365);
        } catch (Exception e) {
            model.addAttribute("code", "-1");
            model.addAttribute("message", "error");
        }
        return "success";
    }




    /**
     * 删除
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id, Model model) {
        System.out.println("delete user id is : " + id);
        try {
            iStudentService.deleteStudent(id);
            model.addAttribute("code", "0");
            model.addAttribute("message", "success");
        } catch (Exception e) {
            model.addAttribute("code", "-1");
            model.addAttribute("message", "error");
        }
        return "success";
    }


    /**
     * ID查询
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") Integer id, Model model) {
        Student student = iStudentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student";
    }

    /**
     * 查询所有
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String list(Model model) {

        try {
            List<Student> list = iStudentService.findAll();
            model.addAttribute("code", "0");
            model.addAttribute("message", "success");
            model.addAttribute("list", list);
        } catch (Exception e) {
            model.addAttribute("code", "-1");
            model.addAttribute("message", "error");
        }
        return "First";
    }


    @RequestMapping(value = "/find/param",method = RequestMethod.GET)
    public String getParam(String name,
                          Model model) {
        System.out.println("name is : "+name);
        List<Student> list = iStudentService.findStudentByName(name);
        model.addAttribute("list", list);
        return "First";
    }
}