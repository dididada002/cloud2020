CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`price` DECIMAL(10,2) NOT NULL COMMENT '订单总价',
`order_status` int(10) NOT NULL DEFAULT '0' COMMENT '订单总价',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

