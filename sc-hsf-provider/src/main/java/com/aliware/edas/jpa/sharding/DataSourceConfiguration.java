package com.aliware.edas.jpa.sharding;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
 
@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource getDataSource() throws SQLException, PropertyVetoException {
        return buildDataSource();
    }
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
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
    private DataSource buildDataSource() throws SQLException, PropertyVetoException {
        // 设置分库映射
        Map<String, DataSource> dataSourceMap = new HashMap(2);
        // 添加两个数据库db0,db1到map里
        dataSourceMap.put("db0", dataSource());
//        dataSourceMap.put("db1", createDataSource("db1"));
        // 设置默认db为db0，也就是为那些没有配置分库分表策略的指定的默认库
        // 如果只有一个库，也就是不需要分库的话，map里只放一个映射就行了，只有一个库时不需要指定默认库，但2个及以上时必须指定默认库，否则那些没有配置策略的表将无法操作数据
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, "db0");
 
        // 设置分表映射，将t_order_0和t_order_1两个实际的表映射到t_order逻辑表
        // 0和1两个表是真实的表，t_order是个虚拟不存在的表，只是供使用。如查询所有数据就是select * from t_order就能查完0和1表的
        TableRule orderTableRule = TableRule.builder("t_order")
                .actualTables(Arrays.asList("t_order_0", "t_order_1"))
                .dataSourceRule(dataSourceRule)
                .build();
 
        // 具体分库分表策略，按什么规则来分
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(orderTableRule))
//                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuleDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuleTableShardingAlgorithm())).build();
 
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
 
        return dataSource;
    }
 
    private static DataSource createDataSource(final String dataSourceName) {
        // 使用druid连接数据库
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://localhost:3306/zhiye", dataSourceName));
        result.setUsername("root");
        result.setPassword("password_root");
        return result;
    }
 
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new DefaultKeyGenerator();
//    }
}