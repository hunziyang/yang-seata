package com.yang.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单(Trade)实体类
 *
 * @author makejava
 * @since 2024-09-01 10:52:04
 */
@Data
@TableName("TRADE")
public class Trade{
/**
     * 主键
     */
    private Long id;
/**
     * 订单
     */
    private String number;
}

