create database ds_0;
create database ds_1;

DROP TABLE IF EXISTS ds_0.`geek_order_0`;
create table ds_0.`geek_order_0`
(
    `id`          bigint(20) unsigned     NOT NULL COMMENT 'ID',
    `shop_id`     bigint(20) unsigned     NOT NULL COMMENT '门店ID',
    `customer_id` bigint(20) unsigned     NOT NULL COMMENT '用户ID',
    `total_price` decimal(16, 2) unsigned NOT NULL COMMENT '订单总价',
    `remark`      varchar(128)            NOT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    KEY `customer_id_index` (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';

DROP TABLE IF EXISTS ds_0.`geek_order_1`;
create table ds_0.`geek_order_1`
(
    `id`          bigint(20) unsigned     NOT NULL COMMENT 'ID',
    `shop_id`     bigint(20) unsigned     NOT NULL COMMENT '门店ID',
    `customer_id` bigint(20) unsigned     NOT NULL COMMENT '用户ID',
    `total_price` decimal(16, 2) unsigned NOT NULL COMMENT '订单总价',
    `remark`      varchar(128)            NOT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    KEY `customer_id_index` (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';


DROP TABLE IF EXISTS ds_1.`geek_order_0`;
create table ds_1.`geek_order_0`
(
    `id`          bigint(20) unsigned     NOT NULL COMMENT 'ID',
    `shop_id`     bigint(20) unsigned     NOT NULL COMMENT '门店ID',
    `customer_id` bigint(20) unsigned     NOT NULL COMMENT '用户ID',
    `total_price` decimal(16, 2) unsigned NOT NULL COMMENT '订单总价',
    `remark`      varchar(128)            NOT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    KEY `customer_id_index` (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';

DROP TABLE IF EXISTS ds_1.`geek_order_1`;
create table ds_1.`geek_order_1`
(
    `id`          bigint(20) unsigned     NOT NULL COMMENT 'ID',
    `shop_id`     bigint(20) unsigned     NOT NULL COMMENT '门店ID',
    `customer_id` bigint(20) unsigned     NOT NULL COMMENT '用户ID',
    `total_price` decimal(16, 2) unsigned NOT NULL COMMENT '订单总价',
    `remark`      varchar(128)            NOT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    KEY `customer_id_index` (`customer_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';


INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (1, 1, 1, 1, "ds1 order1");
INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (2, 3, 2, 1, "ds1 order0");
INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (3, 2, 3, 1, "ds0 order1");
INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (4, 10, 10, 1, "ds0 order0");
