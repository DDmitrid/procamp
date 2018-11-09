package com.globallogic.procamp.lesson5.validation;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.Validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = ValidationController.class)
public class ValidationControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testValidationGet() throws Exception {

        mvc.perform(get("/validation")
                        .contentType("application/json"))
                        .andExpect(status().isOk());
    }

    @Test
    public void testValidationPost() throws Exception {
        
        BeanDto beanDTO = new BeanDto();
         String body = objectMapper.writeValueAsString(beanDTO);

        mvc.perform(get("/validation")
                        .contentType("application/json")
                        .content(body))
                        .andExpect(status().isBadRequest());
    }
}

