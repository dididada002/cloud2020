package com.jt.springcloud.service;

import com.jt.springcloud.modul.request.HysTestForm;
import com.jt.springcloud.modul.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:09
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIC-PAYMENT",fallback = HystricPaymentFeignServiceFallback.class)
public interface HystricPaymentFeignService {

    @PostMapping("/pay/hys/ok")
    Result testOk(@RequestBody HysTestForm form);

    @PostMapping("/pay/hys/timeout")
    Result testTimeOut(@RequestBody HysTestForm form);

    @PostMapping("/pay/hys/rongduan")
    Result testRongDuan(HysTestForm form);
}
