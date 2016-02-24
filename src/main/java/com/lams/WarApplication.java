package com.lams;



import com.alibaba.druid.pool.DruidDataSource;
import com.lams.pojo.SUser;
import com.lams.util.DruidProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by DaMo on 2015/12/9.
 */
@Configuration
@SpringBootApplication
@EnableConfigurationProperties(com.lams.util.DruidProperties.class)
@MapperScan("com.lams.dao.mapper")
public class WarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApplication.class);
    }

    @Bean
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(druidProperties.getUsername());
        druidDataSource.setPassword(druidProperties.getPassword());
        druidDataSource.setUrl(druidProperties.getUrl());
        try {
            druidDataSource.setFilters(druidProperties.getFilter());
        } catch (SQLException e) {
            logger.error("init druid test sql error!");
        }
        druidDataSource.setMaxActive(druidProperties.getMaxActive());
        druidDataSource.setInitialSize(druidProperties.getInitialSize());
        druidDataSource.setMinIdle(druidProperties.getMinIdle());
        druidDataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidProperties.getTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(druidProperties.getTestOnReturn());
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }

    //    @Bean
//    public ExpectedApprovalSoap expectedApprovalSoap(){
//        URL url = null;
//        try {
//            url = new URL(oaTodoWsURL);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return new ExpectedApproval(url).getExpectedApprovalSoap();
//    }

    @Bean
    public SUser sUser(){
        SUser user = new SUser();
        user.setUsername("sdfsdf2fcsdcw");
        return user;
    }
    @Autowired
    protected DruidProperties druidProperties;
}
