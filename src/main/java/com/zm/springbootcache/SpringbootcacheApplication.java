package com.zm.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/*
    SpringBoot cache

 */
@SpringBootApplication
@MapperScan(value = "com.zm.springbootcache.dao")
@EnableCaching      //开启全局缓存
public class SpringbootcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcacheApplication.class, args);
    }

    @Bean
    public ViewResolver resolver(){
        return new myViewResolver();
    }

    public static class myViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
