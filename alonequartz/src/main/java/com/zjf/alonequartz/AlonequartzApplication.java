package com.zjf.alonequartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableScheduling
public class AlonequartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlonequartzApplication.class, args);
    }

}
