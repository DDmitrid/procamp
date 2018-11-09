package com.globallogic.procamp.lesson5.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
@ContextConfiguration(classes = { ProfilesConfig.class }/*, loader = AnnotationConfigContextLoader.class*/)
public class SpringProfilesTest {

    @Autowired
    DatasourceConfig datasourceConfig;

    @Test
    public void name() {
        datasourceConfig.setup();
    }
}
