package com.aliware.edas.dynamic;

import com.dynamic.datasource.C3P0DataSourceHome;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
@Component
@RestController
public class EntryController {
//    @Resource
//    private JDBCDataSourceHome JDBCDataSourceHome;
    @Resource
    private C3P0DataSourceHome C3P0DataSourceHome = new C3P0DataSourceHome();
    @RequestMapping(value = "/datasource", method = RequestMethod.GET)
    public String datasource() throws Exception {
//        DataSource jdbcDataSource = JDBCDataSourceHome.getJDBCDataSource();
        DataSource c3p0DataSource = C3P0DataSourceHome.createC3P0DataSource();
        SqlSessionFactory sqlSessionFactory = C3P0DataSourceHome.createMysqlSqlSessionFactory();
        C3P0DataSourceHome.testSqlsession();
        return "1";
    }

}
