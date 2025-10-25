# 请你作为后端开发人员，生成五个表user_auth_email、user_auth_mobile、user_info、user_login_log、user_logout_log的模拟数据，user_info生成5条用户数据，分别在user_auth_email和user_auth_mobile生成邮箱和手机认证，在user_login_log和user_logout_log生成登录和登出日志
# 要求输出SQL代码块，里面使用SQL插入语句


-- Insert into user_info
INSERT INTO user_info (user_id, real_name, nick_name, mobile, email, salt, registry_time, create_user, update_user)
VALUES
    (1, 'John Doe', 'johnny', '12345678901', 'john@example.com', 'salt1', '2025-01-01 00:00:00', 1, 1),
    (2, 'Jane Smith', 'jane', '12345678902', 'jane@example.com', 'salt2', '2025-01-02 00:00:00', 2, 2),
    (3, 'Alice Johnson', 'alice', '12345678903', 'alice@example.com', 'salt3', '2025-01-03 00:00:00', 3, 3),
    (4, 'Bob Brown', 'bob', '12345678904', 'bob@example.com', 'salt4', '2025-01-04 00:00:00', 4, 4),
    (5, 'Charlie Davis', 'charlie', '12345678905', 'charlie@example.com', 'salt5', '2025-01-05 00:00:00', 5, 5);

-- Insert into user_auth_email
INSERT INTO user_auth_email (user_id, email, password, create_user, update_user)
VALUES
    (1, 'john@example.com', 'hashed_password1', 1, 1),
    (2, 'jane@example.com', 'hashed_password2', 2, 2),
    (3, 'alice@example.com', 'hashed_password3', 3, 3),
    (4, 'bob@example.com', 'hashed_password4', 4, 4),
    (5, 'charlie@example.com', 'hashed_password5', 5, 5);

-- Insert into user_auth_mobile
INSERT INTO user_auth_mobile (user_id, mobile, password, create_user, update_user)
VALUES
    (1, '12345678901', 'hashed_password1', 1, 1),
    (2, '12345678902', 'hashed_password2', 2, 2),
    (3, '12345678903', 'hashed_password3', 3, 3),
    (4, '12345678904', 'hashed_password4', 4, 4),
    (5, '12345678905', 'hashed_password5', 5, 5);

-- Insert into user_login_log
INSERT INTO user_login_log (user_id, login_type, device, login_time, ip, create_user, update_user)
VALUES
    (1, 1, 1, '2025-10-01 10:00:00', '192.168.0.1', 1, 1),
    (1, 2, 2, '2025-10-02 11:00:00', '192.168.0.2', 1, 1),
    (2, 1, 1, '2025-10-03 12:00:00', '192.168.0.3', 2, 2),
    (2, 2, 2, '2025-10-04 13:00:00', '192.168.0.4', 2, 2),
    (3, 1, 1, '2025-10-05 14:00:00', '192.168.0.5', 3, 3),
    (3, 2, 2, '2025-10-06 15:00:00', '192.168.0.6', 3, 3),
    (4, 1, 1, '2025-10-07 16:00:00', '192.168.0.7', 4, 4),
    (4, 2, 2, '2025-10-08 17:00:00', '192.168.0.8', 4, 4),
    (5, 1, 1, '2025-10-09 18:00:00', '192.168.0.9', 5, 5),
    (5, 2, 2, '2025-10-10 19:00:00', '192.168.0.10', 5, 5);

-- Insert into user_logout_log
INSERT INTO user_logout_log (user_id, logout_type, device, logout_time, ip, create_user, update_user)
VALUES
    (1, 1, 1, '2025-10-01 11:00:00', '192.168.0.1', 1, 1),
    (1, 2, 2, '2025-10-02 12:00:00', '192.168.0.2', 1, 1),
    (2, 1, 1, '2025-10-03 13:00:00', '192.168.0.3', 2, 2),
    (2, 2, 2, '2025-10-04 14:00:00', '192.168.0.4', 2, 2),
    (3, 1, 1, '2025-10-05 15:00:00', '192.168.0.5', 3, 3),
    (3, 2, 2, '2025-10-06 16:00:00', '192.168.0.6', 3, 3),
    (4, 1, 1, '2025-10-07 17:00:00', '192.168.0.7', 4, 4),
    (4, 2, 2, '2025-10-08 18:00:00', '192.168.0.8', 4, 4),
    (5, 1, 1, '2025-10-09 19:00:00', '192.168.0.9', 5, 5),
    (5, 2, 2, '2025-10-10 20:00:00', '192.168.0.10', 5, 5);
