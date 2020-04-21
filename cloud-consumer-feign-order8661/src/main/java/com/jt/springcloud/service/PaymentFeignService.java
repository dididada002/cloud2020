package com.jt.springcloud.service;

import com.jt.springcloud.modul.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:09
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/pay/get/by/{id}")
    public Result getById(@PathVariable("id") Long id);

    @GetMapping("/pay/test/time/out")
    Result testTimeOut();

}
