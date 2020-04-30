package com.mango.eureka;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 新版的security默认启用了csrf校验
        // eureka开启security后，需要禁用csrf，客户端才能正常注册；同时permit /actuator/**，以解决spring boot admin监控不到的问题。
        // config server同样，在开启security后，加解密接口encrypt访问不到，需要禁用csrf；同时permit /actuator/**以解决spring boot admin监控不到的问题。
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest()
                .authenticated().and().httpBasic();
    }
}
