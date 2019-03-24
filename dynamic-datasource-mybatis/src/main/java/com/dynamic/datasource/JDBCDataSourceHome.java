package com.dynamic.datasource;

//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class JDBCDataSourceHome {
    private DriverManagerDataSource driverManagerDataSource;

    public DriverManagerDataSource getJDBCDataSource() {
        synchronized (driverManagerDataSource) {
            if (driverManagerDataSource == null) {
                driverManagerDataSource = new DriverManagerDataSource();
                driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
                driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/zhiye");
                driverManagerDataSource.setUsername("root");
                driverManagerDataSource.setPassword("password_root");
            }
        }
        return driverManagerDataSource;
    }
}
