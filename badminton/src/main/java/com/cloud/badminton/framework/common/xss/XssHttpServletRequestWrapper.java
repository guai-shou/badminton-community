package com.cloud.badminton.framework.common.xss;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HtmlUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 21:57
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.hasLength(value)) {
            value = HtmlUtil.filter(value);
        }
        return value;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        /*非json类型, 直接返回*/
        if (!isJsonRequest()) {
            return super.getInputStream();
        }
        ServletInputStream inputStream = super.getInputStream();
        String s = IoUtil.read(inputStream, StandardCharsets.UTF_8);

        if (StringUtils.hasLength(s)) {
            s = HtmlUtil.filter(s);
        }

        final ByteArrayInputStream bain = new ByteArrayInputStream(s.getBytes());

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return bain.read();
            }
        };
    }



    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (StringUtils.hasLength(value)) {
            value = HtmlUtil.filter(value);
        }
        return value;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = super.getParameterMap();
        final LinkedHashMap<String, String[]> map = new LinkedHashMap<>();
        if (parameterMap != null) {
            for (String key : parameterMap.keySet()) {
                String[] values = parameterMap.get(key);
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    if (StringUtils.hasLength(value)) {
                        value = HtmlUtil.filter(value);
                    }
                    values[i] = value;
                }
                map.put(key, values);
            }
        }

        return map;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            if (StringUtils.hasLength(value)) {
                value = HtmlUtil.filter(value);
            }
            values[i] = value;
        }
        return values;
    }



    private boolean isJsonRequest() {
        String header = super.getHeader(HttpHeaders.CONTENT_TYPE);
        return MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(header)
                || MediaType.APPLICATION_JSON_UTF8_VALUE.equalsIgnoreCase(header);
    }

}
