package com.istio.front.sample.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.istio.front.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class SampleRestController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/login")
    public Map login(Model model, HttpServletResponse response){

        //sampleService.login()
        //model.addAttribute("map", sampleService.login());
        //return "index";

        Map result = sampleService.login();

        response.addHeader("Authorization", result.get("auth").toString());

        return result;
    }

    @GetMapping("/auth/authApi")
    public Map authPage(Model model, HttpServletRequest resuest){

        String token = resuest.getHeader("Authorization");
        log.debug("authPage::token::" + token);

        return sampleService.authPage(token);
    }
}
