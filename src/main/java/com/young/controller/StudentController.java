package com.young.controller;

import com.young.pojo.Student;
import com.young.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author 闫亮23
 * @version 1.0
 */

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    // 查询所有学生
    @RequestMapping("/emps1")
    @ResponseBody
    public ModelAndView list(Model model) {
        Collection<Student> students = studentService.findAll();
        model.addAttribute("emps", students);
        return new ModelAndView("emp/list");
    }

    // 查询单个学生
    @RequestMapping("/emps2")
    @ResponseBody
    public ModelAndView list01(Model model) {
        return new ModelAndView("emp/list");
    }

    // 按照数学成绩排名
    @RequestMapping("/emps3")
    @ResponseBody
    public ModelAndView rank(Model model) {
        Collection<Student> students = studentService.getRankByMath();
        model.addAttribute("emps", students);
        return new ModelAndView("emp/rank");
    }

    // 返回首页
    @RequestMapping("/stu")
    @ResponseBody
    public ModelAndView toHead() {
        return new ModelAndView("dashboard");
    }

    // 添加学生
    @GetMapping("/emp")
    @ResponseBody
    public ModelAndView toAdd(Student student) {
        return new ModelAndView("emp/add");
    }

    // 更改学生
    @GetMapping("/emp1")
    @ResponseBody
    public ModelAndView toUpdate(Student student) {
        return new ModelAndView("emp/update");
    }

    // 删除学生
    @GetMapping("/emp2")
    @ResponseBody
    public ModelAndView toDelete() {
        return new ModelAndView("emp/delete");
    }

    // 查询学生
    @GetMapping("/emp3")
    @ResponseBody
    public ModelAndView toQuery() {

        return new ModelAndView("emp/query");
    }

    // 添加学生
    @PostMapping("/emp")
    @ResponseBody
    public ModelAndView addStu(Student student) {
        studentService.save(student);
        return new ModelAndView("redirect:/emps1");
    }
    // 更改学生
    @PostMapping("/emp1")
    @ResponseBody
    public ModelAndView updateStu(Student student) {
        studentService.updateByPrimaryKeySelective(student);
        return new ModelAndView("redirect:/emps1");
    }

    // 删除学生
    @PostMapping("/emp2")
    @ResponseBody
    public ModelAndView deleteStu(Integer id) {
        studentService.deleteByPrimaryKey(id);
        return new ModelAndView("redirect:/emps1");
    }

    // 查询学生
    @PostMapping("/emp3")
    @ResponseBody
    public ModelAndView deleteStu(Model model,String name) {
        Student student = studentService.selectByName(name);
        model.addAttribute("emps", student);
        return new ModelAndView("emp/list01");
    }


}


