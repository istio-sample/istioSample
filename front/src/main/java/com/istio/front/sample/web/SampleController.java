package com.istio.front.sample.web;

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

    @GetMapping("/authPage")
    public String authPage(Model model){

        model.addAttribute("map", sampleService.authPage());
        return "authPage";
    }
}
