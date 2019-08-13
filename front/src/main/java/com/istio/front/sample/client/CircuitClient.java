package com.istio.front.sample.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * CircuitClient
 */
@FeignClient(name = "circuit", url = "${feign.core1.url}")
public interface CircuitClient {
    @GetMapping("/circuits/circuit01")
    public Map<String, String> circuit01(@RequestParam String circuitType,
            @RequestParam int failRate, @RequestParam int responseCode, @RequestParam long delay);

}