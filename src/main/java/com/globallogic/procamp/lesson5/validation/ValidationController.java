package com.globallogic.procamp.lesson5.validation;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "validation")
public class ValidationController {
    

    @PostMapping
    public BeanDto validate(@Validated(value = CreateBeanDtoValidation.class) @RequestBody BeanDto bean) {
        return bean;
    }

    @PutMapping
    public BeanDto validate2(@Validated(value = UpdateBeanDtoValidation.class) @RequestBody BeanDto bean) {
        return bean;
    }

    @GetMapping(params = {"int", "string", "email"})
    public String validate(
                    @RequestParam("int") @Min(1) @Max(5)  int i,
                    @RequestParam ("string") @Size(min = 1, max = 32)  String s,
                    @RequestParam("email") @Email String email ) {
        
        return String.format("%s::%s::%s", i, s, email);
    }
}
