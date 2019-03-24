package com.dynamic.datasource;


import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class C3P0DataSourceHome {

    private DriverManagerDataSource driverManagerDataSource;
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    public synchronized DriverManagerDataSource createC3P0DataSource() {
        if (driverManagerDataSource == null) {
            driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClass("com.mysql.jdbc.Driver");
            driverManagerDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/zhiye?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=false&serverTimezone=UTC");
            driverManagerDataSource.setUser("root");
            driverManagerDataSource.setPassword("password_root");
        }
        return driverManagerDataSource;
    }

    public synchronized SqlSessionFactory createMysqlSqlSessionFactory() throws Exception {
        if (sqlSessionFactoryBean == null) {
            sqlSessionFactoryBean = new SqlSessionFactoryBean();
            //这里需要一个dataSource
            //上面的已经发布了两个dataSource的bean，这里如何把上面发布的mysqlDataSource注入过来
            //就像 applicationContext.getBean("mysqlDataSource") 一样，拿到;
            if (driverManagerDataSource == null) {
                this.createC3P0DataSource();
            }
            sqlSessionFactoryBean.setDataSource(driverManagerDataSource);
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        }
        return sqlSessionFactoryBean.getObject();
    }

    public void testSqlsession() throws Exception {
        if (driverManagerDataSource == null) {
            this.createC3P0DataSource();
        }
        SqlSession sqlSession = createMysqlSqlSessionFactory().openSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ZhiyeDAO zhiyeDAO = sqlSession.getMapper(ZhiyeDAO.class);
        zhiyeDAO.saveZhiye(new ArrayList<ZhiyeVo>(){{add(new ZhiyeVo());}});
    }
}
