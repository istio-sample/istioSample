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

@Controller
@Slf4j
@RequestMapping("/")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/")
    public String main(){
        log.debug("Call main");
        return "index";
    }

    @GetMapping("/ab")
    public String ab(Model model){

        model.addAttribute("map", sampleService.ab());
        return "ab";
    }

    @GetMapping("/auth/authPage")
    public String authPage(Model model, HttpServletRequest resuest){

        String auth = resuest.getHeader("Authorization");
        log.debug("authPage::auth::" + auth);

        //model.addAttribute("map", sampleService.authPage());
        return "authPage";
    }
}
