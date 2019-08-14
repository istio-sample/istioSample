package com.istio.product.web;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class ProductController {

    @GetMapping("/productInfo")
    public Map productInfo(){

        Map map = new HashMap();

        map.put("product-info", "product-info version 2 contents");

        log.info("productInfo::" + map );

        return map;
    }
}
