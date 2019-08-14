package com.istio.front.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "product", url = "${feign.product.url}")
public interface ProductClient {

    @GetMapping("/productInfo")
    public Map productInfo();
}
