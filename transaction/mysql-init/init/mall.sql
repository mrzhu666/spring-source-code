# 请你作为资深Java后端开发，请根据 https://mp.weixin.qq.com/s/0_5mPhZPdBzb5Gk4ijyQZg 这篇文章生成相关的数据库表，要求相关代码符合规范，比如字段要有注释等

create
    database if not exists account_ddd character set utf8mb4 collate utf8mb4_unicode_ci;

use account_ddd;

-- 创建产品表，用于存储商品信息，包括库存
CREATE TABLE IF NOT EXISTS product
(
    product_id  BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '产品ID，主键，自增',
    name        VARCHAR(255)   NOT NULL COMMENT '产品名称',
    stock       INT            NOT NULL DEFAULT 0 COMMENT '产品库存数量',
    price       DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '产品价格',

    create_user BIGINT         NOT NULL COMMENT '创建者',
    update_user BIGINT         NOT NULL COMMENT '更新者',
    create_time TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_deleted  TINYINT(1)     NOT NULL DEFAULT 0 COMMENT '是否删除 | 0、未删除 1、已删除',
    version     INT UNSIGNED   NOT NULL DEFAULT 0 COMMENT '版本号'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='产品表';

-- 创建订单表，用于存储订单信息
CREATE TABLE IF NOT EXISTS orders
(
    order_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '订单ID，主键，自增',
    product_id  BIGINT       NOT NULL COMMENT '产品ID，外键引用产品表',
    quantity    INT          NOT NULL DEFAULT 1 COMMENT '订单数量',
#     total_price DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '订单总价',
    user_id     BIGINT       NOT NULL COMMENT '用户ID',

    create_user BIGINT       NOT NULL COMMENT '创建者',
    update_user BIGINT       NOT NULL COMMENT '更新者',
    create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_deleted  TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否删除 | 0、未删除 1、已删除',
    version     INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '版本号',
    FOREIGN KEY (product_id) REFERENCES product (product_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='订单表';