/*公共表*/

CREATE TABLE `t_dict` (
	`dict_id` BIGINT(20) NOT NULL COMMENT 'id',
	`type` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
	`code` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
	`value` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
	PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;