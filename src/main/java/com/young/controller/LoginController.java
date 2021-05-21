package com.young.controller;

import com.young.dao.StudentMapper;
import com.young.pojo.Student;
import com.young.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author 闫亮23
 * @version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/user/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        // 此为登录业务
        Student student = studentService.selectByAdmin(username);
        if (student != null && student.getPwd().equals(password)) {
            String name = student.getName();
            session.setAttribute("loginUser", name);
            return new ModelAndView("redirect:/main.html");

        } else {
            model.addAttribute("msg", "用户名或密码有误");
            return new ModelAndView("index");
        }
    }
}
//
//    @RequestMapping("/user/register")
//    @ResponseBody
//    public ModelAndView register(@RequestParam("username") String username,
//                              @RequestParam("password") String password,
//                              Model model,
//                               HttpSession session) {
//        // 此为注册业务
//        session.setAttribute("loginUser",username);
//        return new ModelAndView("redirect:/main.html");
//    }






        //        if(!StringUtils.isEmpty(username) && "123".equals(password)) {
//            session.setAttribute("loginUser",username);
//            return new ModelAndView("redirect:/main.html");
//        } else{
//            model.addAttribute("msg","用户名或密码有误");
//            return new ModelAndView("index");
//        }



