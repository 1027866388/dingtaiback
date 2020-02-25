/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.dingtai.customermager.config;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.filter.FormValidFilter;
import com.dingtai.customermager.service.impl.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 *
 * @author vic
 * @date 2018-03-26 20:38
 */
@Configuration
public class ShiroConfig {

    @Bean("sessionManager")
    public SessionManager sessionManager() {

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(DateTimeConstant.HOUR_MS);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        SimpleCookie cookie = new SimpleCookie("SMARTAUDITJSESSIONID");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 1000);
        sessionManager.setSessionIdCookie(cookie);
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(final UserRealm userRealm, final SessionManager sessionManager) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(final SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login.html");
        shiroFilter.setUnauthorizedUrl("/");
        Map<String, String> filterMap = new LinkedHashMap<>();
        // swagger
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        // 登录相关
        filterMap.put("/login/login", "anon");
        filterMap.put("/login/loginNoCaptcha", "anon");
        filterMap.put("/login/loginNoCaptchaEncryPass", "anon");
        filterMap.put("/login/captcha", "anon");
        filterMap.put("/login/logout", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/commontool/*", "anon");
        filterMap.put("/attachment/uploadBigFile", "anon");
        filterMap.put("/user/resetPassword", "anon");
        filterMap.put("/user/sendResetPwdEmail", "anon");
        // 其他接口
        filterMap.put("/**", "authc");
        Map<String, Filter> filterChain = shiroFilter.getFilters();
        filterChain.put("authc", new FormValidFilter());
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            final SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
