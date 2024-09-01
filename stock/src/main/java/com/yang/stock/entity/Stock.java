package com.yang.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 库存(Stock)实体类
 *
 * @author makejava
 * @since 2024-09-01 10:50:31
 */
@Data
@TableName("STOCK")
public class Stock{
/**
     * 主键
     */
    private Long id;
/**
     * 商品ID
     */
    private Long productId;

}

