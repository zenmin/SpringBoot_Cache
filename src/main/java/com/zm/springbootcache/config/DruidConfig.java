package com.zm.springbootcache.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is Druid配置类
 * @Author ZengMin
 * @Date 2018/7/1 16:33
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> params = new HashMap<>();
        params.put("loginUsername","root");
        params.put("loginPassword","root");
        servletRegistrationBean.setInitParameters(params);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidFileter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        Map<String, String> params  = new HashMap<>();
        params.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(params);
        return filterRegistrationBean;
    }
}
