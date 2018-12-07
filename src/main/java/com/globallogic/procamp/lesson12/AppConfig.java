package com.globallogic.procamp.lesson12;

import com.globallogic.procamp.lesson12.latency.LatencyDatasource;
import com.globallogic.procamp.lesson12.latency.LatencySimulator;
import com.globallogic.procamp.lesson12.latency.ThreadSleepLatencySimulator;
import com.p6spy.engine.spy.P6DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;



@Configuration
@ComponentScan
@PropertySource({"classpath:jdbc.properties", "classpath:app.properties"})
@EnableTransactionManagement
public class AppConfig {

  private final Environment env;

  @Autowired
  public AppConfig(Environment env) {
    this.env = env;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws NamingException, IOException {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(LatencySimulator latencySimulator) throws NamingException, IOException {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    factory.setJpaDialect(new HibernateJpaDialect());
    factory.setPackagesToScan("com.globallogic.procamp.lesson12.entity");
    factory.setDataSource(dataSource(latencySimulator));
    factory.setJpaProperties(jpaProperties());
    return factory;
  }

  @Bean
  public DataSource dataSource(LatencySimulator latencySimulator) throws NamingException {
    DriverManagerDataSource realDatasource = new DriverManagerDataSource();
    realDatasource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    realDatasource.setUrl(env.getProperty("jdbc.url"));
    realDatasource.setUsername(env.getProperty("jdbc.username"));
    realDatasource.setPassword(env.getProperty("jdbc.password"));
      return new P6DataSource(
                      new LatencyDatasource(realDatasource, latencySimulator)
              )
      ;
  }

  @Bean
  public LatencySimulator latencySimulator() {
    return new ThreadSleepLatencySimulator(Long.valueOf(env.getProperty("extra_latency")));
  }

  private Properties jpaProperties() throws IOException {
    Properties properties = new Properties();
    try (InputStream inputStream = new ClassPathResource("hibernate.properties").getInputStream()) {
      properties.load(inputStream);
    }
    return properties;
  }

}
