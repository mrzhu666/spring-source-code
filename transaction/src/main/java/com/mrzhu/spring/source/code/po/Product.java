package com.mrzhu.spring.source.code.po;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 产品表
 *
 * @TableName product
 */
@TableName(value = "product")
@Data
public class Product {
    /**
     * 产品ID，主键，自增
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Long productId;
    
    /**
     * 产品名称
     */
    @TableField(value = "name")
    private String name;
    
    /**
     * 产品库存数量
     */
    @TableField(value = "stock")
    private Integer stock;
    
    /**
     * 产品价格
     */
    @TableField(value = "price")
    private BigDecimal price;
    
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