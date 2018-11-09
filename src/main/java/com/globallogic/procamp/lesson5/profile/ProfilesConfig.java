package com.globallogic.procamp.lesson5.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.globallogic.procamp.lesson5.profile")
@PropertySource(value = "classpath:application.properties")
public class ProfilesConfig {

}
