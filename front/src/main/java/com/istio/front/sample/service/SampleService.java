package com.istio.front.sample.service;

import com.istio.front.sample.client.AuthClient;
import com.istio.front.sample.client.SampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Service
@Slf4j
public class SampleService {

    @Autowired
    private SampleClient sampleClient;

    @Autowired
    private AuthClient authClient;

    public Map ab(){
        return sampleClient.sample();
    }

    public Map authPage(){

        Map resultMap = authClient.authInfo();
        log.debug(resultMap.toString());
        return resultMap;
    }
}
