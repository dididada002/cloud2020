create database `user_db` character set 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `t_user` (
	`user_id` BIGINT(20) NOT NULL COMMENT '用户id',
	`user_name` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
	`status` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '用户状态，0-正常  1-禁用',
	PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;