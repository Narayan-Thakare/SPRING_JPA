package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;




@Controller
public class MyController {

  @Autowired  
StudentRepo stu;
  
    @RequestMapping("/")
    String myfun(Model m) {
        Student s = new Student();

        System.out.println("Data in	 u object from " + s);
        m.addAttribute("obj", s);

        return "page1.html";
    }

    @RequestMapping("/data")
    ModelAndView myfun2(@ModelAttribute("obj") Student s) {
        System.out.println("Data in u object from After " + s);
        
        stu.save(s);

        
        
        ModelAndView mv = new ModelAndView("welcome.html");
        mv.addObject("ob", s);

        return mv;
    }
}
