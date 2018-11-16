package com.globallogic.procamp.lesson7.data.repository;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.globallogic.procamp.lesson7.data.ProcampApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = ProcampApplication.class)
@TestExecutionListeners({
                TransactionalTestExecutionListener.class,
                DependencyInjectionTestExecutionListener.class
})
public abstract class BaseRunner {
}
