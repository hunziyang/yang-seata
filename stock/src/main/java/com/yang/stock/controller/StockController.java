package com.yang.stock.controller;

import com.yang.stock.config.result.Result;
import com.yang.stock.entity.Stock;
import com.yang.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockMapper stockMapper;

    @GetMapping
//    @GlobalTransactional
    public Result getStock(Long id) {
        Stock stock = new Stock();
        stock.setProductId(id);
        stock.setCount(10);
        stockMapper.insert(stock);
        int i = 1/0;
        return Result.success();
    }
}
