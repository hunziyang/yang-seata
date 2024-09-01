package com.yang.order.feign;

import com.yang.order.config.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignService {

    @GetMapping
    public Result getStock(@RequestParam("id") Long id);
}
