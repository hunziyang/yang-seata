package com.yang.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.ZonedDateTime;

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
/**
     * 状态
     */
    private Integer status;
/**
     * 原因
     */
    private String message;
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

