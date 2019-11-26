package com.zjf.alonequartz.common.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.zjf.alonequartz.common.DataSources.DataSourceNames;
import com.zjf.alonequartz.common.DataSources.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置
 */
@Configuration
@MapperScan("com.zjf.alonequartz.**.mapper*")
public class MybatisPluConfig {

    /**
     * 数据源配置
     * @return
     */

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.druid.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.druid.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource,DataSource secondDataSource){
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
