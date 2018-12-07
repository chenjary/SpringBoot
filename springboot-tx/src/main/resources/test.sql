-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.22-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------


-- 导出 springboot_test 的数据库结构
CREATE DATABASE IF NOT EXISTS `springboot_test` 
USE `springboot_test`;

-- 导出  表 springboot_test.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  springboot_test.user 的数据：~0 rows (大约)

INSERT INTO `user` (`id`, `name`, `age`) VALUES
	(1, 'chenjay', 22),
	(2, 'lucy', 19),
	(3, 'mary', 35);

