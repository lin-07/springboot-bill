package com.lq.springboot.config;


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

@Configuration
public class DruidConfig {

    /**
     * 使用druid的数据源
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    /**
     * 配置druid监控
     * 1、注册servlet
     * 2、注册filter
     */
    // 配置druid的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        // 所有的以druid开头的请求
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        // 设置初始化参数
        Map<String,String> initParam = new HashMap<>();
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD, "root");
        //如果不写，则默认所有ip都可以访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        initParam.put(StatViewServlet.PARAM_NAME_DENY, "192.168.10.1");
        bean.setInitParameters(initParam);
        return bean;
    }

    // 配置druid的过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        // 设置过滤器拦截排除路径
        Map<String, String> initPrams = new HashMap<>();
        initPrams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        // 设置过滤器拦截路径
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
