package com.yang.order.controller;

import com.yang.order.config.result.Result;
import com.yang.order.entity.Trade;
import com.yang.order.feign.ScoreFeignService;
import com.yang.order.feign.StockFeignService;
import com.yang.order.mapper.TradeMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private TradeMapper tradeMapper;

    @Autowired
    private ScoreFeignService scoreFeignService;

    @Autowired
    private StockFeignService stockFeignService;

    @GlobalTransactional(rollbackFor = Exception.class)
    @GetMapping
    public Result getTrade(){
        Trade trade = new Trade();
        trade.setNumber(UUID.randomUUID().toString());
        trade.setStatus(0);
        tradeMapper.insert(trade);
        scoreFeignService.setScore(trade.getId());
        stockFeignService.getStock(trade.getId());
        return Result.success(trade);
    }
}
