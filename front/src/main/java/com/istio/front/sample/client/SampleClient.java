package com.istio.front.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "core1", url = "${feign.core1.url}")
public interface SampleClient {

    @GetMapping("/sample1")
    public Map sample();
}
