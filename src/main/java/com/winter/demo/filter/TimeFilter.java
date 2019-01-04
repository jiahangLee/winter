package com.winter.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filterInit");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("timeBefore={}",new Date().getTime());
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("timeAfter={}",new Date().getTime());
    }

    @Override
    public void destroy() {
        log.info("filterDestroy");
    }
}
