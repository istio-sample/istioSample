package com.istio.front.sample.service;

import com.istio.front.sample.client.AuthClient;
import com.istio.front.sample.client.CircuitClient;
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

    @Autowired
    private CircuitClient circuitClient;

    public Map ab(){
        return sampleClient.sample();
    }

    public Map authPage(){

        Map resultMap = authClient.authInfo();
        log.debug(resultMap.toString());
        return resultMap;
    }

    public Map circuit01(String circuitType, int failRate, int responseCode){
        Map resultMap = circuitClient.circuit01(circuitType, failRate, responseCode)
        log.info("circuit01");
        return resultMap;
    }
}
