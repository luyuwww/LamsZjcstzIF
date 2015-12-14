package com.lams;

import com.alibaba.druid.pool.DruidDataSource;
import com.lams.util.DruidProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by DaMo on 2015/12/9.
 */
@Configuration
@SpringBootApplication
@EnableConfigurationProperties(DruidProperties.class)
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

}
