package com.aliware.edas.jpa;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.beans.PropertyVetoException;

//@Configuration
@Slf4j
public class DBConfig {
    @Autowired
    private Environment env;
    @PostConstruct
    private void init(){
        log.info("dbConfig is init");
    }
    @Bean(name="dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        log.info("env:{}",env.getProperty("spring.hsf.version"));
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/zhiye?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSf4=false&serverTimezone=UTC");
//        dataSource.setDriverClass(env.getProperty("ms.db.driverClassName"));
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("password_root");
        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(5);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(300);
        dataSource.setAcquireIncrement(5);
        dataSource.setIdleConnectionTestPeriod(60);

        return dataSource;
    }

}