package com.istio.core1.sample.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {

    @Value("${bgenv}")
    private String bgenv;

    @GetMapping("/sample1")
    public Map sample(){

        Map map = new HashMap();

        map.put("park", "chulman");
        map.put("lee", "jungsuk");
        map.put("choi", "sungwook");
        map.put("test4", "test4");
        map.put("test5", "test5");
        map.put("test6", "test6");
        map.put("test7", "test7");

        map.put("env", bgenv);

        return map;
    }
}
