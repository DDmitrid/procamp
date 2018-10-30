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
    public String hello() {
        return "hello";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Andrii") String name, Model model) {
        model.addAttribute("name", name);
        
        //        model.a
        //        model.asMap().put("","");

        //        Map<String, String> map = new HashMap<>();
        //        map.put("smth", "value");
        //        
        //        model.mergeAttributes(map);

        return "greeting";
    }



    @GetMapping("/welcome")
    public ModelAndView welocome(@RequestParam(name = "name", required = false, defaultValue = "ProCamp") String name) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("name", name);
        
        return modelAndView;
    }


    @GetMapping("/list")
    public String displayList(ModelMap modelMap) {

        List<String> names = Arrays.asList(
                        "Denys Dvornyi",
                        "Sergey Nechosov",
                        "Dmitriy Malyarchuk",
                        "Dmitry Dudin",
                        "Yurii Vasylchuk",
                        "Alexandr Garkusha"
        );

        modelMap.addAttribute("names", names);

        return "list";
    }

    @ModelAttribute("secret")
    public String getAttribute() {
        return "Secret Data";
    }
   
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
