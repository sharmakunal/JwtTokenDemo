package rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import interceptor.AuthInterceptor;
import interceptor.CorsInterceptor;

@Configuration  
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter  {  

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/token/*");
       registry.addInterceptor(new CorsInterceptor());
    }
} 
