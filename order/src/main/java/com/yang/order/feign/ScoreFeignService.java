package com.yang.order.feign;

import com.yang.order.config.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "score-service",path = "/score")
public interface ScoreFeignService {

    @GetMapping
    Result setScore(@RequestParam("id") Long id);
}
