package com.istio.front.sample.service;

import com.istio.front.sample.client.SampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SampleService {

    @Autowired
    private SampleClient sampleClient;

    public Map ab(){
        return sampleClient.sample();
    }
}
