package com.lams;

import com.alibaba.druid.pool.DruidDataSource;
import com.lams.util.DruidProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by DaMo on 2015/12/9.
 */
@Configuration
@SpringBootApplication
@EnableConfigurationProperties(DruidProperties.class)
@MapperScan("com.lams.dao.mapper")
public class WarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }

    @Bean
    public DruidDataSource druidDataSource(DruidProperties dp){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(dp.getUsername());
        druidDataSource.setPassword(dp.getPassword());
        druidDataSource.setUrl(dp.getUrl());
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DruidProperties dp) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource(dp));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DruidProperties dp) {
        return new DataSourceTransactionManager(druidDataSource(dp));
    }

}
