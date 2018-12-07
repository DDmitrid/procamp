package com.globallogic.procamp.lesson12.tasks;

import org.flywaydb.core.Flyway;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import lombok.SneakyThrows;


public class FlywayDbHelper {
    
  @SneakyThrows
  public static void migrate() {
      
    Properties properties = new Properties();
    try (InputStream inputStream = new FileInputStream("src/main/resources/db/flyway.conf")) {
      properties.load(inputStream);
    }
    Flyway flyway = new Flyway();
    flyway.configure(properties);
    flyway.clean();
    flyway.migrate();
  }
}
