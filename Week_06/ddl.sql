#####  2.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交DDL的SQL文件到Github（后面2周的作业依然要是用到这个表结构）。
DROP TABLE IF EXISTS `geek_customer`;
create table `geek_customer`
(
    `id`            bigint(20) unsigned NOT NULL COMMENT 'ID',
    `account`       varchar(32)         NOT NULL COMMENT '账户',
    `password`      varchar(32)         NOT NULL COMMENT '密码',
    `mobile`        char(11)            NOT NULL COMMENT '手机号',
    `name`          varchar(32)         NOT NULL COMMENT '姓名',
    `created_time`  datetime            NOT NULL COMMENT '创建时间',
    `modified_time` datetime            NOT NULL COMMENT '最后修改时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

DROP TABLE IF EXISTS `geek_commodity`;
create table `geek_commodity`
(
    `id`            bigint(20) unsigned    NOT NULL COMMENT 'ID',
    `name`          varchar(32)            NOT NULL COMMENT '商品名称',
    `price`         decimal(6, 2) unsigned NOT NULL COMMENT '单价',
    `created_time`  datetime               NOT NULL COMMENT '创建时间',
    `modified_time` datetime               NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品表';

DROP TABLE IF EXISTS `geek_order`;
create table `geek_order`
(
    `id`            bigint(20) unsigned     NOT NULL COMMENT 'ID',
    `customer_id`   bigint(20) unsigned     NOT NULL COMMENT '用户ID',
    `total_price`   decimal(16, 2) unsigned NOT NULL COMMENT '订单总价',
    `created_time`  datetime                NOT NULL COMMENT '创建时间',
    `modified_time` datetime                NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY `customer_id_index` (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';

DROP TABLE IF EXISTS `geek_order_commodity`;
create table `geek_order_commodity`
(
    `id`            bigint(20) unsigned NOT NULL COMMENT 'ID',
    `commodity_id`  bigint(20) unsigned NOT NULL COMMENT '商品ID',
    `price`         decimal(6, 2) unsigned DEFAULT NULL COMMENT '商品单价',
    `amount`        decimal(6, 2) unsigned DEFAULT NULL COMMENT '商品数量',
    `created_time`  datetime               DEFAULT NULL COMMENT '创建时间',
    `modified_time` datetime               DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY `commodity_id_id_index` (`commodity_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单商品表';