package com.dingtai.customermager.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 *  基础数据库Mybatis配置
 *  
 *  @author wangyanhui
 *  @date 2019-01-29 19:02
 *  
 */
@Configuration
@MapperScan(basePackages = {"com.dingtai.customermager.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisDataConfig {
    public static final String MAPPER_LOCATION = "classpath:mapping/*.xml";
    public static final String CONFIG_LOCATION = "classpath:mybatis-config.xml";

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        Resource[] locationResource = new PathMatchingResourcePatternResolver().getResources(MybatisDataConfig.MAPPER_LOCATION);
        Resource configResource = new PathMatchingResourcePatternResolver().getResource(MybatisDataConfig.CONFIG_LOCATION);
        factoryBean.setMapperLocations(locationResource);
        factoryBean.setConfigLocation(configResource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}
