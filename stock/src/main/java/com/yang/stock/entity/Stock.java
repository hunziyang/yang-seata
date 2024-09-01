package com.yang.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.ZonedDateTime;

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
/**
     * 数量
     */
    private Integer count;
/**
     * 唯一性锁
     */
    private Integer uniqueKey;
/**
     * 乐观锁
     */
    private Integer revision;
/**
     * 逻辑删
     */
    private Integer isDelete;
/**
     * 创建人编号
     */
    private Long createdId;
/**
     * 创建人姓名
     */
    private String createdName;
/**
     * 创建时间
     */
    private ZonedDateTime createdTime;
/**
     * 更新人编号
     */
    private Long updatedId;
/**
     * 更新人姓名
     */
    private String updatedName;
/**
     * 更新时间
     */
    private ZonedDateTime updatedTime;

}

