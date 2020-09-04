-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.17 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 db_embp_example 的数据库结构
DROP DATABASE IF EXISTS `db_embp_example`;
CREATE DATABASE IF NOT EXISTS `db_embp_example` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_embp_example`;

-- 导出  表 db_embp_example.sys_menu 结构
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT '1' COMMENT '排序值',
  `keep_alive` char(1) DEFAULT '0' COMMENT '0-开启，1- 关闭',
  `type` char(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator_num` varchar(64) DEFAULT NULL COMMENT '创建人',
  `updater_num` varchar(64) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10020 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- 正在导出表  db_embp_example.sys_menu 的数据：~54 rows (大约)
DELETE FROM `sys_menu`;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`menu_id`, `name`, `permission`, `path`, `parent_id`, `icon`, `component`, `sort`, `keep_alive`, `type`, `del_flag`, `remark`, `create_time`, `update_time`, `creator_num`, `updater_num`) VALUES
	(1000, '权限管理', NULL, '/admin', -1, 'icon-quanxianguanli', NULL, 0, '0', '0', '0', NULL, '2018-09-28 08:29:53', '2020-03-11 23:58:18', NULL, NULL),
	(1100, '用户管理', NULL, '/admin/user/index', 1000, 'icon-yonghuguanli', NULL, 1, '0', '0', '0', NULL, '2017-11-02 22:24:37', '2020-03-12 00:12:57', NULL, NULL),
	(1101, '用户新增', 'sys_user_add', NULL, 1100, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 09:52:09', '2018-09-28 09:06:34', NULL, NULL),
	(1102, '用户修改', 'sys_user_edit', NULL, 1100, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 09:52:48', '2018-09-28 09:06:37', NULL, NULL),
	(1103, '用户删除', 'sys_user_del', NULL, 1100, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 09:54:01', '2018-09-28 09:06:42', NULL, NULL),
	(1200, '菜单管理', NULL, '/admin/menu/index', 1000, 'icon-caidanguanli', NULL, 2, '0', '0', '0', NULL, '2017-11-08 09:57:27', '2020-03-12 00:13:52', NULL, NULL),
	(1201, '菜单新增', 'sys_menu_add', NULL, 1200, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:15:53', '2018-09-28 09:07:16', NULL, NULL),
	(1202, '菜单修改', 'sys_menu_edit', NULL, 1200, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:16:23', '2018-09-28 09:07:18', NULL, NULL),
	(1203, '菜单删除', 'sys_menu_del', NULL, 1200, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:16:43', '2018-09-28 09:07:22', NULL, NULL),
	(1300, '角色管理', NULL, '/admin/role/index', 1000, 'icon-jiaoseguanli', NULL, 3, '0', '0', '0', NULL, '2017-11-08 10:13:37', '2020-03-12 00:15:40', NULL, NULL),
	(1301, '角色新增', 'sys_role_add', NULL, 1300, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:14:18', '2018-09-28 09:07:46', NULL, NULL),
	(1302, '角色修改', 'sys_role_edit', NULL, 1300, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:14:41', '2018-09-28 09:07:49', NULL, NULL),
	(1303, '角色删除', 'sys_role_del', NULL, 1300, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-08 10:14:59', '2018-09-28 09:07:53', NULL, NULL),
	(1304, '分配权限', 'sys_role_perm', NULL, 1300, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-04-20 07:22:55', '2018-09-28 09:13:23', NULL, NULL),
	(1400, '部门管理', NULL, '/admin/dept/index', 1000, 'icon-web-icon-', NULL, 4, '0', '0', '0', NULL, '2018-01-20 13:17:19', '2020-03-12 00:15:44', NULL, NULL),
	(1401, '部门新增', 'sys_dept_add', NULL, 1400, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-01-20 14:56:16', '2018-09-28 09:08:13', NULL, NULL),
	(1402, '部门修改', 'sys_dept_edit', NULL, 1400, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-01-20 14:56:59', '2018-09-28 09:08:16', NULL, NULL),
	(1403, '部门删除', 'sys_dept_del', NULL, 1400, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-01-20 14:57:28', '2018-09-28 09:08:18', NULL, NULL),
	(2000, '系统管理', NULL, '/setting', -1, 'icon-xitongguanli', NULL, 1, '0', '0', '0', NULL, '2017-11-07 20:56:00', '2020-03-11 23:52:53', NULL, NULL),
	(2100, '日志管理', NULL, '/admin/log/index', 2000, 'icon-rizhiguanli', NULL, 5, '0', '0', '0', NULL, '2017-11-20 14:06:22', '2020-03-12 00:15:49', NULL, NULL),
	(2101, '日志删除', 'sys_log_del', NULL, 2100, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-20 20:37:37', '2018-09-28 09:08:44', NULL, NULL),
	(2200, '字典管理', NULL, '/admin/dict/index', 2000, 'icon-navicon-zdgl', NULL, 6, '0', '0', '0', NULL, '2017-11-29 11:30:52', '2020-03-12 00:15:58', NULL, NULL),
	(2201, '字典删除', 'sys_dict_del', NULL, 2200, NULL, NULL, NULL, '0', '1', '0', NULL, '2017-11-29 11:30:11', '2018-09-28 09:09:10', NULL, NULL),
	(2202, '字典新增', 'sys_dict_add', NULL, 2200, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-05-11 22:34:55', '2018-09-28 09:09:12', NULL, NULL),
	(2203, '字典修改', 'sys_dict_edit', NULL, 2200, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-05-11 22:36:03', '2018-09-28 09:09:16', NULL, NULL),
	(2300, '令牌管理', NULL, '/admin/token/index', 2000, 'icon-denglvlingpai', NULL, 11, '0', '0', '0', NULL, '2018-09-04 05:58:41', '2020-03-13 12:57:25', NULL, NULL),
	(2301, '令牌删除', 'sys_token_del', NULL, 2300, NULL, NULL, 1, '0', '1', '0', NULL, '2018-09-04 05:59:50', '2020-03-13 12:57:34', NULL, NULL),
	(2400, '终端管理', '', '/admin/client/index', 2000, 'icon-shouji', NULL, 9, '0', '0', '0', NULL, '2018-01-20 13:17:19', '2020-03-12 00:15:54', NULL, NULL),
	(2401, '客户端新增', 'sys_client_add', NULL, 2400, '1', NULL, NULL, '0', '1', '0', NULL, '2018-05-15 21:35:18', '2018-09-28 09:10:25', NULL, NULL),
	(2402, '客户端修改', 'sys_client_edit', NULL, 2400, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-05-15 21:37:06', '2018-09-28 09:10:27', NULL, NULL),
	(2403, '客户端删除', 'sys_client_del', NULL, 2400, NULL, NULL, NULL, '0', '1', '0', NULL, '2018-05-15 21:39:16', '2018-09-28 09:10:30', NULL, NULL),
	(2500, '服务监控', NULL, 'http://127.0.0.1:5001', 2000, 'icon-server', NULL, 10, '0', '0', '0', NULL, '2018-06-26 10:50:32', '2019-02-01 20:41:30', NULL, NULL),
	(3000, '开发平台', NULL, '/gen', -1, 'icon-shejiyukaifa-', NULL, 3, '1', '0', '0', NULL, '2020-03-11 22:15:40', '2020-03-11 23:52:54', NULL, NULL),
	(3100, '数据源管理', NULL, '/gen/datasource', 3000, 'icon-mysql', NULL, 1, '1', '0', '0', NULL, '2020-03-11 22:17:05', '2020-03-12 00:16:09', NULL, NULL),
	(3200, '代码生成', NULL, '/gen/index', 3000, 'icon-weibiaoti46', NULL, 2, '0', '0', '0', NULL, '2020-03-11 22:23:42', '2020-03-12 00:16:14', NULL, NULL),
	(3300, '表单管理', NULL, '/gen/form', 3000, 'icon-record', NULL, 3, '1', '0', '0', NULL, '2020-03-11 22:19:32', '2020-03-12 00:16:18', NULL, NULL),
	(3301, '表单新增', 'gen_form_add', NULL, 3300, '', NULL, 0, '0', '1', '0', NULL, '2018-05-15 21:35:18', '2020-03-11 22:39:08', NULL, NULL),
	(3302, '表单修改', 'gen_form_edit', NULL, 3300, '', NULL, 1, '0', '1', '0', NULL, '2018-05-15 21:35:18', '2020-03-11 22:39:09', NULL, NULL),
	(3303, '表单删除', 'gen_form_del', NULL, 3300, '', NULL, 2, '0', '1', '0', NULL, '2018-05-15 21:35:18', '2020-03-11 22:39:11', NULL, NULL),
	(3400, '表单设计', NULL, '/gen/design', 3000, 'icon-biaodanbiaoqian', NULL, 4, '1', '0', '0', NULL, '2020-03-11 22:18:05', '2020-03-12 00:16:25', NULL, NULL),
	(9999, '系统官网', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2019-01-17 17:05:19', '2020-03-11 23:52:57', NULL, NULL),
	(10000, '444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2019-01-17 17:05:19', '2020-08-24 17:26:39', 'System', 'System'),
	(10005, '系统官网2222', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-24 20:34:08', '2020-08-24 20:34:08', 'System', 'System'),
	(10006, '系统官网2222', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-24 20:35:30', '2020-08-24 20:35:30', 'System', 'System'),
	(10007, '系统官网2222', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-24 20:50:06', '2020-08-24 20:50:06', 'System', 'System'),
	(10008, '434', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-25 06:28:35', '2020-08-25 06:36:25', 'System', 'System'),
	(10009, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-25 06:37:42', '2020-08-25 06:37:42', 'System', 'System'),
	(10010, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 16:49:19', '2020-08-27 16:49:19', 'System', 'System'),
	(10011, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 16:51:43', '2020-08-27 16:51:43', 'System', 'System'),
	(10012, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 16:57:30', '2020-08-27 16:57:30', 'System', 'System'),
	(10013, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:05:36', '2020-08-27 17:05:36', 'System', 'System'),
	(10014, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:10:38', '2020-08-27 17:10:38', 'System', 'System'),
	(10015, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:10:52', '2020-08-27 17:10:52', 'System', 'System'),
	(10016, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:26:29', '2020-08-27 17:26:29', 'System', 'System'),
	(10017, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:31:35', '2020-08-27 17:31:35', 'System', 'System'),
	(10018, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:36:26', '2020-08-27 17:36:26', 'System', 'System'),
	(10019, '44466666666666644444', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '0', NULL, '2020-08-27 17:57:03', '2020-08-27 17:57:03', 'System', 'System');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

-- 导出  表 db_embp_example.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `remark` varchar(1024) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `creator_num` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `updater_num` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系统角色表';

-- 正在导出表  db_embp_example.sys_role 的数据：~1 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_code`, `role_desc`, `remark`, `create_time`, `update_time`, `creator_num`, `updater_num`, `del_flag`) VALUES
	(1, '管理员', 'ROLE_ADMIN', '管理员', NULL, '2017-10-29 15:45:51', '2018-12-26 14:09:11', NULL, NULL, '0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 db_embp_example.sys_role_menu 结构
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

-- 正在导出表  db_embp_example.sys_role_menu 的数据：~41 rows (大约)
DELETE FROM `sys_role_menu`;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES
	(1, 1000),
	(1, 1100),
	(1, 1101),
	(1, 1102),
	(1, 1103),
	(1, 1200),
	(1, 1201),
	(1, 1202),
	(1, 1203),
	(1, 1300),
	(1, 1301),
	(1, 1302),
	(1, 1303),
	(1, 1304),
	(1, 1400),
	(1, 1401),
	(1, 1402),
	(1, 1403),
	(1, 2000),
	(1, 2100),
	(1, 2101),
	(1, 2200),
	(1, 2201),
	(1, 2202),
	(1, 2203),
	(1, 2300),
	(1, 2301),
	(1, 2400),
	(1, 2401),
	(1, 2402),
	(1, 2403),
	(1, 2500),
	(1, 3000),
	(1, 3100),
	(1, 3200),
	(1, 3300),
	(1, 3301),
	(1, 3302),
	(1, 3303),
	(1, 3400),
	(1, 9999);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;

-- 导出  表 db_embp_example.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '简介',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `lock_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '0-正常，9-锁定',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '0-正常，1-删除',
  `remark` varchar(1024) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `creator_num` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `updater_num` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`user_id`),
  KEY `user_idx1_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- 正在导出表  db_embp_example.sys_user 的数据：~3 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `salt`, `phone`, `avatar`, `dept_id`, `lock_flag`, `del_flag`, `remark`, `create_time`, `update_time`, `creator_num`, `updater_num`) VALUES
	(1, 'admin', '$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC', NULL, '17034642999', '', 1, '0', '0', NULL, '2018-04-20 07:15:18', '2019-01-31 14:29:07', NULL, NULL),
	(2, 'dbdu', '$2a$10$rV4VfCgMDS89IQuQI4dp6.BEFhO0rAG3Tx6QkZ3WfI1wfgqOxnwim', NULL, '13700009999', NULL, 2, '0', '0', NULL, '2020-07-06 18:46:40', '2020-08-24 13:35:06', NULL, NULL),
	(4, 'test', '$2a$10$2ISv1ybPvwbJ0ICyQNvjKeVJlm8BhqDa7oaydShBex2QTus/HpJ1a', NULL, '13400001111', NULL, 11, '0', '0', NULL, '2020-08-19 12:02:08', '2020-08-19 12:05:29', 'System', 'System');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 db_embp_example.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- 正在导出表  db_embp_example.sys_user_role 的数据：~3 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
