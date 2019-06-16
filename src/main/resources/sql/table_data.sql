/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.24-log : Database - spring-boot-mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring-boot-mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring-boot-mybatis`;

/*Table structure for table `sys_data_dictionary` */

DROP TABLE IF EXISTS `sys_data_dictionary`;

CREATE TABLE `sys_data_dictionary` (
  `sdr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id,自增',
  `sdr_name` varchar(64) NOT NULL COMMENT '字典名',
  `sdr_value` varchar(128) DEFAULT NULL COMMENT '字典值value',
  `sdr_parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `sdr_level` int(11) NOT NULL COMMENT '层级关系',
  `sdr_order` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`sdr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_data_dictionary` */

insert  into `sys_data_dictionary`(`sdr_id`,`sdr_name`,`sdr_value`,`sdr_parent_id`,`sdr_level`,`sdr_order`) values 
(1,'anonymous_access_url','匿名访问url',NULL,0,1),
(2,'/sysUser/doLogin','跳转到登录页',1,1,1),
(3,'/sysUser/login','用户登录',1,1,2),
(4,'/sysUser/logout','用户注销',1,1,3),
(5,'/index/validatecode','验证码',1,1,4),
(6,'common_access_url','公共访问url',NULL,0,2),
(7,'/','系统根路径',6,1,1),
(8,'/index','系统首页',6,1,2),
(9,'/sysUser/settingData','用户设置基本资料',6,1,3);

/*Table structure for table `sys_privilege` */

DROP TABLE IF EXISTS `sys_privilege`;

CREATE TABLE `sys_privilege` (
  `sp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `sp_name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `sp_uri` varchar(128) DEFAULT NULL COMMENT '资源uri',
  `sp_type` int(11) DEFAULT NULL COMMENT '资源类型(1:模块;2:菜单;3:按钮)',
  `sp_parent_id` int(11) DEFAULT NULL COMMENT '父权限id',
  `sp_orderd` int(11) DEFAULT NULL COMMENT '位置排序',
  `sp_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sp_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `sys_privilege` */

insert  into `sys_privilege`(`sp_id`,`sp_name`,`sp_uri`,`sp_type`,`sp_parent_id`,`sp_orderd`,`sp_create_time`,`sp_update_time`) values 
(1,'用户管理','/sysUser/list',2,6,1,'2018-08-16 15:56:34','2019-06-16 22:16:14'),
(2,'用户管理查询','/sysUser/list',3,1,NULL,'2018-08-16 15:58:21','2018-08-16 15:58:29'),
(3,'用户管理新增','/sysUser/add',3,1,NULL,'2018-08-16 15:58:23','2018-08-16 15:58:32'),
(4,'用户管理修改','/sysUser/edit',3,1,NULL,'2018-08-16 15:58:25','2018-08-16 15:58:36'),
(5,'用户管理删除','/sysUser/delete',3,1,NULL,'2018-08-16 15:58:27','2018-08-16 15:58:34'),
(6,'系统管理','',1,0,6,'2018-08-17 18:33:01','2019-06-16 22:18:48'),
(7,'角色管理查询','/sysRole/list',3,11,NULL,'2018-08-17 19:21:05','2018-08-17 19:21:12'),
(8,'角色管理新增','/sysRole/add',3,11,NULL,'2018-08-17 19:21:07','2018-08-17 19:21:16'),
(9,'角色管理修改','/sysRole/edit',3,11,NULL,'2018-08-17 19:21:09','2018-08-17 19:21:14'),
(10,'角色管理删除','/sysRole/delete',3,11,NULL,'2018-08-17 19:21:10','2018-08-17 19:21:18'),
(11,'角色管理','/sysRole/list',2,6,2,'2018-08-17 19:21:32','2018-08-17 19:21:20'),
(12,'菜单管理','/sysMenu/list',2,6,3,'2018-08-17 19:21:34','2018-08-17 19:21:23'),
(13,'菜单管理查询','/sysMenu/list',3,12,NULL,'2018-08-17 19:21:36','2018-08-17 19:21:26'),
(14,'菜单管理新增','/sysMenu/add',3,12,NULL,'2018-08-17 19:21:38','2018-08-17 19:21:28'),
(15,'菜单管理修改','/sysMenu/edit',3,12,NULL,'2018-08-17 19:21:40','2018-08-17 19:21:30'),
(16,'菜单管理删除','/sysMenu/delete',3,12,NULL,'2018-08-17 19:21:42','2018-08-17 19:21:44'),
(18,'分配权限','/sysMenu/allotSysPrivilege',3,11,NULL,'2018-08-17 21:32:52','2018-08-17 21:32:54'),
(19,'分配角色','/sysRole/allotSysRole',3,1,NULL,'2018-08-18 00:36:21','2018-08-18 00:36:23');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id,自增',
  `sr_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `sr_description` varchar(64) DEFAULT NULL COMMENT '角色描述',
  `sr_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sr_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`sr_id`,`sr_name`,`sr_description`,`sr_create_time`,`sr_update_time`) values 
(1,'管理员','拥有系统所有权限','2018-08-16 15:53:46','2018-08-16 15:53:48'),
(2,'普通用户','只拥有普通权限','2018-08-16 15:54:18','2018-08-17 20:43:00');

/*Table structure for table `sys_role_privilege` */

DROP TABLE IF EXISTS `sys_role_privilege`;

CREATE TABLE `sys_role_privilege` (
  `srp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限表主键id,自增',
  `srp_role_id` int(11) DEFAULT NULL COMMENT '角色表主键id',
  `srp_privilege_id` int(11) DEFAULT NULL COMMENT '权限表主键id',
  PRIMARY KEY (`srp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_privilege` */

insert  into `sys_role_privilege`(`srp_id`,`srp_role_id`,`srp_privilege_id`) values 
(76,1,1),
(77,1,2),
(78,1,3),
(79,1,4),
(80,1,5),
(81,1,6),
(82,1,7),
(83,1,8),
(84,1,9),
(85,1,10),
(86,1,11),
(87,1,12),
(88,1,13),
(89,1,14),
(90,1,15),
(91,1,16),
(92,1,18),
(93,1,19),
(94,1,21),
(95,2,1),
(96,2,2),
(97,2,6);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `su_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id,自增',
  `su_login_name` varchar(32) NOT NULL COMMENT '登录名',
  `su_real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `su_password` varchar(32) NOT NULL COMMENT '密码',
  `su_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `su_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_login_name`,`su_real_name`,`su_password`,`su_create_time`,`su_update_time`) values 
(1,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','2018-08-16 11:01:55','2018-08-16 11:01:55'),
(2,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','2018-08-16 15:52:44','2018-08-16 15:52:45'),
(4,'zzp','zzp','e10adc3949ba59abbe56e057f20f883e','2018-08-17 20:15:41','2018-08-17 20:15:41'),
(5,'wangwu','王五','123456','2019-05-06 22:44:37','2019-05-06 22:44:37'),
(19,'dadsasd','dadsad','8f4031bfc7640c5f267b11b6fe0c2507','2019-06-16 17:55:11','2019-06-16 17:55:11'),
(20,'sfsdf','fsfsdf','c73aa4f9bdfc15de604d63550e47de5a','2019-06-16 18:10:12','2019-06-16 18:10:12');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `sur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表主键,自增',
  `sur_user_id` int(11) DEFAULT NULL COMMENT '用户表主键',
  `sur_role_id` int(11) DEFAULT NULL COMMENT '角色表主键',
  PRIMARY KEY (`sur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`sur_id`,`sur_user_id`,`sur_role_id`) values 
(1,1,1),
(4,4,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
