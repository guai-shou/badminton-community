package com.cloud.badminton.framework.common.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 21:51
 */
/**/
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*可以获得初始参数*/
        //filterConfig.getInitParameterNames()
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        /*先进行转义, 在把请求返回*/
        XssHttpServletRequestWrapper wrapper = new XssHttpServletRequestWrapper(httpServletRequest);
        chain.doFilter(wrapper, response);
    }
}
