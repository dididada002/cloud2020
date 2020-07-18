package com.jt.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jingteng
 * @date: 2020/7/18 23:49
 */
@RestController
@RequestMapping("/config")
public class ConfigClientController {


    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/get/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
