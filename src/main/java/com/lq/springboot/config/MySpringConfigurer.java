package com.lq.springboot.config;

import com.lq.springboot.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration // 声明是一个配置类
public class MySpringConfigurer {

    // 视图控制器
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptor(){
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        User user = (User) request.getSession().getAttribute("user");
                        if(!StringUtils.isEmpty(user)){
                            return true;
                        }else{
                            request.setAttribute("msg","无此访问权限");
                            request.getRequestDispatcher("/index.html").forward(request,response);
                            return false;
                        }
                    }
                        // 拦截所有请求
                }).addPathPatterns("/**")
                        // 排除不需要拦截的请求
                  .excludePathPatterns("/","/index.html","/login")
                        // springboot2.x需要排除静态资源路径
                  .excludePathPatterns("/css/*","/img/*","/js/*");
            }
        };
    }
    // 自定义区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolver(){
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                String l = request.getParameter("l");
                Locale local = Locale.getDefault();
                if (!StringUtils.isEmpty(l)){
                    String[] split = l.split("_");
                    local = new Locale(split[0], split[1]);
                }
                return local;
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        };
    }
}
