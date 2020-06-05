package com.jt.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: jingteng
 * @date: 2020/6/6 0:41
 */
@Configuration
public class DatabaseConfiguration {
    private final ApplicationContext applicationContext;

    public DatabaseConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource ds0(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    @Primary
    public DataSource dataSource(DruidDataSource ds0){
        DataSourceProxy dataSourceProxy = new DataSourceProxy(ds0);
        return dataSourceProxy;
    }
}
