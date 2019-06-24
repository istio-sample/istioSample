package com.istio.front.sample.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class HeaderInterceptor implements RequestInterceptor {

    @Value("${istio.green.domain:localhost}")
    private String greenDomain;

    @Override
    public void apply(RequestTemplate template) {
        HttpServletRequest orgRequest = null;

        if (RequestContextHolder.getRequestAttributes() != null) {
            orgRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }

        String serverName = orgRequest.getServerName();
        log.debug("serverName : {}", serverName);
        if(greenDomain.equals(serverName)){
            template.header("x-env", "green");
        }
    }
}
