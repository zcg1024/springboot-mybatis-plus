-- schema-h2.sql
-- DROP TABLE IF EXISTS `user`;
-- CREATE TABLE user (
--     id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
--     username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
--     password VARCHAR(100) NOT NULL COMMENT '密码',
--     age INT NULL DEFAULT NULL COMMENT '年龄',
--     email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
--     enabled BOOLEAN DEFAULT TRUE COMMENT '是否可用',
--     lang VARCHAR(10) DEFAULT 'en' COMMENT '中文：zh / 英文：en'
-- ) COMMENT '用户表';


-- schema-h2.sql
-- H2 不支持直接在列定义中使用 COMMENT 关键字
-- H2 使用 IDENTITY 而不是 AUTO_INCREMENT
DROP TABLE IF EXISTS "user";
CREATE TABLE "user" (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(50),
    enabled BOOLEAN DEFAULT TRUE,
    lang VARCHAR(10) DEFAULT 'en'
);
COMMENT ON TABLE "user" IS '用户表';
COMMENT ON COLUMN "user".id IS '主键';
COMMENT ON COLUMN "user".username IS '用户名';
COMMENT ON COLUMN "user".password IS '密码';
COMMENT ON COLUMN "user".age IS '年龄';
COMMENT ON COLUMN "user".email IS '邮箱';
COMMENT ON COLUMN "user".enabled IS '是否可用';
COMMENT ON COLUMN "user".lang IS '中文：zh / 英文：en';


DROP TABLE IF EXISTS "t_simple";
CREATE TABLE "t_simple"(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50)
);
COMMENT ON TABLE "t_simple" IS '用户表';
COMMENT ON COLUMN "t_simple".id IS '主键';
COMMENT ON COLUMN "t_simple".username IS '用户名';
COMMENT ON COLUMN "t_simple".password IS '密码';
COMMENT ON COLUMN "t_simple".email IS '邮箱';
