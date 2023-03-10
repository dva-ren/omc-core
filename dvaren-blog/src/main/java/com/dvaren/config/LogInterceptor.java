package com.dvaren.config;

import com.dvaren.service.ILogService;
import com.dvaren.utils.IpUtil;
import org.jetbrains.annotations.NotNull;
import com.dvaren.domain.entity.Log;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 拦截器：验证用户是否登录
 */
@Configuration
public class LogInterceptor implements HandlerInterceptor {

    @Resource
    private ILogService logService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        Log log = new Log();
        log.setIp(IpUtil.getIpAddr(request));
        log.setPath(request.getRequestURI());
        log.setUa(request.getHeader("User-Agent"));
        logService.addLog(log);
        return true;
    }

}