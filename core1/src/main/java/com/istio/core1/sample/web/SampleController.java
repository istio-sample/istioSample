package com.istio.core1.sample.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class SampleController {

    @Value("${bgenv:BLUE}")
    private String bgenv;

    @GetMapping("/sample1")
    public Map sample(@RequestHeader Map<String, String> headers){

        Map map = new HashMap();

        map.put("park", "chulman");
        map.put("lee", "jungsuk");
        map.put("choi", "sungwook");
        map.put("test4", "test4");
        map.put("test5", "test5");
        map.put("test6", "test6");
        map.put("test7", "test7");
        map.put("env", bgenv);


        log.debug(headers.toString());


        return map;
    }
}
