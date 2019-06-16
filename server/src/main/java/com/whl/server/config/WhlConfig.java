package com.whl.server.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 注释：whl 数据库的数据源配置
 *
 * @Author:whl
 * @Date:2019-06-12 12:28
 */
@Configuration
@MapperScan(basePackages = "com.whl.server.dao.whl", sqlSessionFactoryRef = "whlSqlSessionFactory")
public class WhlConfig {

    @Value("${spring.datasource.whl.type}")
    private String type;

    @Value("${spring.datasource.whl.url}")
    private String url;

    @Value("${spring.datasource.whl.username}")
    private String userName;

    @Value("${spring.datasource.whl.password}")
    private String password;

    @Value("${spring.datasource.whl.driver-class-name}")
    private String driverClassName;

    /**
     * 配置数据业务数据源
     */
    @Bean(name = "whlDataSource")
    @Primary
    public DataSource whlDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 配置业务SqlSessionFactory
     */
    @Bean(name = "whlSqlSessionFactory")
    @Primary
    public SqlSessionFactory whlSqlSessionFactory(@Qualifier("WhlDataSource") DataSource lessonDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(lessonDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/whl/*.xml"));
        sessionFactory.setVfs(SpringBootVFS.class);
        return sessionFactory.getObject();

    }

    /**
     * 配置业务事物管理
     */
    @Bean(name = "whlTransactionManager")
    @Primary
    public DataSourceTransactionManager whlTransactionManager() {
        return new DataSourceTransactionManager(whlDruidDataSource());
    }

    @Bean(name = "whlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("whlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
