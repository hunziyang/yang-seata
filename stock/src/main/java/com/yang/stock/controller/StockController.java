package com.yang.stock.controller;

import com.yang.stock.config.result.Result;
import com.yang.stock.entity.Stock;
import com.yang.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockMapper stockMapper;

    @GetMapping
    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @GlobalTransactional
    public Result getStock(Long id) {
        Stock stock = new Stock();
        stock.setProductId(id);
        stockMapper.insert(stock);
        if (true){
            throw new RuntimeException("123");
        }
        return Result.success();
    }
}
