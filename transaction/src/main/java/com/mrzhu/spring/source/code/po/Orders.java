package com.mrzhu.spring.source.code.po;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import lombok.Data;

/**
 * 订单表
 *
 * @TableName orders
 */
@TableName(value = "orders")
@Data
public class Orders {
    /**
     * 订单ID，主键，自增
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;
    
    /**
     * 产品ID，外键引用产品表
     */
    @TableField(value = "product_id")
    private Long productId;
    
    /**
     * 订单数量
     */
    @TableField(value = "quantity")
    private Integer quantity;
    
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;
    
    /**
     * 创建者
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;
    
    /**
     * 更新者
     */
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
    
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    
    /**
     * 是否删除 | 0、未删除 1、已删除
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Integer isDeleted;
    
    /**
     * 版本号
     */
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;
}