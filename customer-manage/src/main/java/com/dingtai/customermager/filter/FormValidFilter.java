package com.dingtai.customermager.filter;

import com.alibaba.fastjson.JSON;
import com.dingtai.customermager.constants.OriginConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.enums.ResultCodeEnum;
import com.dingtai.customermager.utils.LogUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;

/**
 *  重写shiro拦截器的认证失败方法
 *  
 *  @author wangyanhui
 *  @date 2018-11-01 15:03
 *  
 */
public class FormValidFilter extends FormAuthenticationFilter {
    private static Logger logger = LogUtil.get();

    /**
     * 重写未认证的方法
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //看OA系统里是否已经登录

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String[] allowOrigins = OriginConstant.ALLOW_ORIGIN;
        String origin = httpServletRequest.getHeader("Origin");
        if (Arrays.asList(allowOrigins).contains(origin)) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        }
        httpServletResponse.setHeader("Allow", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");


        //按照标准的而返回格式返回未认证的信息
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("utf-8");
        Result result = new Result(ResultCodeEnum.UN_AUTHENED, "未认证");
        HashMap hashMap = new HashMap(16);
        hashMap.put("data", result.getData());
        hashMap.put("status", result.getStatus());
        hashMap.put("msg", result.getMsg());
        hashMap.put("respTime", result.getRespTime());
        httpServletResponse.getWriter().write(JSON.toJSONString(hashMap));
        httpServletResponse.flushBuffer();
        return false;
    }


}
