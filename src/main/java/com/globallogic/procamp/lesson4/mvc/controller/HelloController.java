package com.globallogic.procamp.lesson4.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="mvc")
public class HelloController {

    
    @GetMapping
    public @ResponseBody String hello() {
        return "hello2";
    }
    
    
    
    
    
    
    
    
    
   
   
   
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
