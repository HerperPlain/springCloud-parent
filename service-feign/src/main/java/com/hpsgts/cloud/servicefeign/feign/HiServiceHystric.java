package com.hpsgts.cloud.servicefeign.feign;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystric implements HiService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "server "+name+" is error";
    }
}
