package com.globallogic.procamp.lesson5.validation;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BeanDto {
    

    @Null(groups = {CreateBeanDtoValidation.class})
    @NotNull(groups = {UpdateBeanDtoValidation.class})
    private int id;
    
    @Size(max = 32, message = "name must be {max}")
    private String name;
    
    @Future
    private Date date;

    @Email
    private String email;

}
