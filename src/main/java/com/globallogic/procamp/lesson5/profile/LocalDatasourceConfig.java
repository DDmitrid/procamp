package com.globallogic.procamp.lesson5.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalDatasourceConfig implements DatasourceConfig {
    
    @Override public void setup() {
        System.out.println("LOCAL profile is active");
    }
}
