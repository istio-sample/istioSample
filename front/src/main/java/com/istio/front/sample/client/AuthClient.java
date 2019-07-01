package com.istio.front.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "auth", url = "${feign.auth.url}")
public interface AuthClient {

    @GetMapping("/authInfo")
    public Map authInfo();
}
