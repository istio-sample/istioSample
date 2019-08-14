package com.istio.front.sample.web;

import javax.servlet.http.HttpServletRequest;
import com.istio.front.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class BlueGreenE2EController {

    @Autowired
    private SampleService sampleService;


    @GetMapping("/bge2e")
    public String blue(Model model,HttpServletRequest resuest, @RequestParam(defaultValue = "all") String circuitType, @RequestParam(defaultValue = "0") int failRate, @RequestParam(defaultValue = "200") int responseCode){

        //model.addAttribute("map", sampleService.circuit01(circuitType, failRate, responseCode));
        String headerHost = "" + resuest.getHeader("Host");
        System.out.println("Header[host]::" + headerHost);

        return headerHost;
    }
}
