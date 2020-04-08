package io.ao9.springaopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
    public String getFortune(boolean tripWire) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(tripWire) throw new RuntimeException("fortune exception");
        return "Heavy traffic this morning";
    }
}