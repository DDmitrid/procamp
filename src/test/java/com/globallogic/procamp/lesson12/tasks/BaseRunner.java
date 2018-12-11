package com.globallogic.procamp.lesson12.tasks;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.globallogic.procamp.lesson12.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TestExecutionListeners({
    TransactionalTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
})
public abstract class BaseRunner {

  @Before
  public void before() {
    FlywayDbHelper.migrate();
  }
}
