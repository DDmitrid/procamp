package com.globallogic.procamp.lesson5.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {
    
    @Override public void setup() {
        System.out.println("DEVELOP profile is active");
    }
}
