package com.lams.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
* Created by luyuwww on 2015-07-09.
*/
@ConfigurationProperties(prefix = "druid.datasource")
public class DruidProperties implements Serializable {

    private String url;
    private String username;
    private String password;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
