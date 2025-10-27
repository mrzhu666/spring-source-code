# 请你作为资深后端开发人员，生成两个表product和orders的模拟数据，要求product表里某一个商品的库存数量为1
# 要求输出SQL代码块，里面使用SQL插入语句

USE account_ddd;

-- Insert simulated data into product table
INSERT INTO product (name, stock, price, create_user, update_user)
VALUES ('Apple iPhone', 10, 999.99, 1, 1),
       ('Samsung Galaxy', 1, 799.99, 1, 1), -- Stock quantity set to 1 for this product
       ('Google Pixel', 5, 699.99, 1, 1);

-- Insert simulated data into orders table
-- Assuming product_ids are auto-incremented starting from 1
INSERT INTO orders (product_id, quantity, user_id, create_user, update_user)
VALUES (1, 1, 1001, 1, 1), -- Order for Apple iPhone
       (2, 1, 1002, 1, 1), -- Order for Samsung Galaxy (stock=1)
       (3, 2, 1003, 1, 1); -- Order for Google Pixel