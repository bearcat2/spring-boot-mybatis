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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

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

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `sj_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统任务id',
  `sj_name` varchar(64) NOT NULL COMMENT '任务名称',
  `sj_group` varchar(64) NOT NULL COMMENT '任务分组',
  `sj_status` int(11) NOT NULL COMMENT '任务状态(1:停止;2:运行)',
  `sj_cron_expression` varchar(64) NOT NULL COMMENT 'cron表达式',
  `sj_description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sj_bean_class` varchar(128) DEFAULT NULL COMMENT '调用类名称(包名+类名)',
  `sj_spring_bean_name` varchar(128) DEFAULT NULL COMMENT 'spring bean名称(IOC容器中bean名称)',
  `sj_method_name` varchar(64) NOT NULL COMMENT '任务调用方法名',
  `sj_create_time` datetime NOT NULL COMMENT '任务创建时间',
  `sj_update_time` datetime DEFAULT NULL COMMENT '任务修改时间',
  PRIMARY KEY (`sj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统任务表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`sj_id`,`sj_name`,`sj_group`,`sj_status`,`sj_cron_expression`,`sj_description`,`sj_bean_class`,`sj_spring_bean_name`,`sj_method_name`,`sj_create_time`,`sj_update_time`) values 
(1,'demo','systemJob',2,'0/5 * * * * ?','run',NULL,'demoJob','run','2019-07-14 22:38:11','2019-07-15 00:35:35');

/*Table structure for table `sys_operate` */

DROP TABLE IF EXISTS `sys_operate`;

CREATE TABLE `sys_operate` (
  `so_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作id,自增',
  `so_name` varchar(32) DEFAULT NULL COMMENT '操作名称',
  `so_show_name` varchar(32) DEFAULT NULL COMMENT '显示名称(操作名的中文显示)',
  `so_orderd` int(11) DEFAULT NULL COMMENT '序号',
  `so_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `so_create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `so_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `so_update_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`so_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='系统操作表';

/*Data for the table `sys_operate` */

insert  into `sys_operate`(`so_id`,`so_name`,`so_show_name`,`so_orderd`,`so_create_time`,`so_create_user`,`so_update_time`,`so_update_user`) values 
(4,'delete','删除',3,'2019-06-26 16:56:17','张三','2019-06-26 16:56:17','张三'),
(5,'detail','查看详情',4,'2019-06-26 16:57:07','张三','2019-06-26 16:57:07','张三'),
(6,'allotPrivilege','分配权限',5,'2019-06-26 16:57:51','张三','2019-06-26 16:57:51','张三'),
(12,'add','新增',1,'2019-06-28 21:37:51','张三','2019-06-28 21:37:51','张三'),
(13,'edit','编辑',2,'2019-06-28 21:38:02','张三','2019-06-28 21:38:36','张三'),
(14,'allotButton','分配按钮',6,'2019-07-13 17:16:56','张三','2019-07-13 17:16:56','张三');

/*Table structure for table `sys_privilege` */

DROP TABLE IF EXISTS `sys_privilege`;

CREATE TABLE `sys_privilege` (
  `sp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `sp_name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `sp_uri` varchar(128) DEFAULT NULL COMMENT '资源uri',
  `sp_type` int(11) DEFAULT NULL COMMENT '资源类型(1:模块;2:菜单;3:按钮)',
  `sp_operate_name` varchar(32) DEFAULT NULL COMMENT '操作名',
  `sp_parent_id` int(11) DEFAULT NULL COMMENT '父权限id',
  `sp_orderd` int(11) DEFAULT NULL COMMENT '位置排序',
  `sp_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sp_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

/*Data for the table `sys_privilege` */

insert  into `sys_privilege`(`sp_id`,`sp_name`,`sp_uri`,`sp_type`,`sp_operate_name`,`sp_parent_id`,`sp_orderd`,`sp_create_time`,`sp_update_time`) values 
(1,'用户管理','/sysUser/pageList',2,NULL,6,1,'2018-08-16 15:56:34','2019-06-16 22:16:14'),
(6,'系统管理','',1,NULL,0,6,'2018-08-17 18:33:01','2019-06-16 22:18:48'),
(8,'新增','/sysRole/add',3,'add',11,NULL,'2018-08-17 19:21:07','2018-08-17 19:21:16'),
(9,'修改','/sysRole/edit',3,'edit',11,NULL,'2018-08-17 19:21:09','2018-08-17 19:21:14'),
(10,'删除','/sysRole/delete',3,'delete',11,NULL,'2018-08-17 19:21:10','2018-08-17 19:21:18'),
(11,'角色管理','/sysRole/pageList',2,NULL,6,2,'2018-08-17 19:21:32','2018-08-17 19:21:20'),
(12,'菜单管理','/sysMenu/pageList',2,NULL,6,3,NULL,'2019-07-14 16:40:24'),
(14,'新增','/sysMenu/add',3,'add',12,NULL,'2018-08-17 19:21:38','2018-08-17 19:21:28'),
(15,'修改','/sysMenu/edit',3,'edit',12,NULL,'2018-08-17 19:21:40','2018-08-17 19:21:30'),
(16,'删除','/sysMenu/delete',3,'delete',12,NULL,'2018-08-17 19:21:42','2018-08-17 19:21:44'),
(18,'分配权限','/sysMenu/allotPrivilege',3,'allotPrivilege',11,NULL,'2018-08-17 21:32:52','2018-08-17 21:32:54'),
(20,'按钮管理','/sysOperate/pageList',2,NULL,6,4,'2019-06-26 15:44:52','2019-06-26 17:01:12'),
(46,'编辑','/sysUser/edit',3,'edit',1,NULL,'2019-07-01 23:09:29','2019-07-01 23:09:29'),
(94,'查看详情','/sysUser/detail',3,'detail',1,NULL,'2019-07-01 23:54:09','2019-07-01 23:54:09'),
(96,'删除','/sysUser/delete',3,'delete',1,NULL,'2019-07-01 23:55:26','2019-07-01 23:55:26'),
(97,'新增','/sysUser/add',3,'add',1,NULL,'2019-07-13 17:04:54','2019-07-13 17:04:54'),
(98,'任务管理','/sysJob/pageList',2,NULL,6,5,NULL,'2019-07-14 16:41:19'),
(99,'新增','/sysOperate/add',3,'add',20,NULL,'2019-07-13 17:13:25','2019-07-13 17:13:25'),
(100,'编辑','/sysOperate/edit',3,'edit',20,NULL,'2019-07-13 17:13:25','2019-07-13 17:13:25'),
(101,'删除','/sysOperate/delete',3,'delete',20,NULL,'2019-07-13 17:13:25','2019-07-13 17:13:25'),
(102,'分配按钮','/sysMenu/allotButton',3,'allotButton',12,NULL,'2019-07-13 17:17:07','2019-07-13 17:17:07');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id,自增',
  `sr_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `sr_description` varchar(64) DEFAULT NULL COMMENT '角色描述',
  `sr_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sr_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

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
) ENGINE=InnoDB AUTO_INCREMENT=482 DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

/*Data for the table `sys_role_privilege` */

insert  into `sys_role_privilege`(`srp_id`,`srp_role_id`,`srp_privilege_id`) values 
(136,2,6),
(137,2,1),
(138,2,3),
(139,2,4),
(140,2,5),
(141,2,21),
(142,2,11),
(143,2,8),
(144,2,9),
(145,2,10),
(146,2,18),
(147,2,12),
(148,2,14),
(149,2,15),
(150,2,16),
(151,2,20),
(461,1,6),
(462,1,1),
(463,1,46),
(464,1,94),
(465,1,96),
(466,1,97),
(467,1,11),
(468,1,8),
(469,1,9),
(470,1,10),
(471,1,18),
(472,1,12),
(473,1,14),
(474,1,15),
(475,1,16),
(476,1,102),
(477,1,20),
(478,1,99),
(479,1,100),
(480,1,101),
(481,1,98);

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_login_name`,`su_real_name`,`su_password`,`su_create_time`,`su_update_time`) values 
(1,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','2018-08-16 11:01:55','2019-07-07 22:22:02'),
(2,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','2018-08-16 15:52:44','2018-08-16 15:52:45'),
(4,'zzp','zzp','e10adc3949ba59abbe56e057f20f883e','2018-08-17 20:15:41','2018-08-17 20:15:41'),
(5,'wangwu','王五','123456','2019-05-06 22:44:37','2019-05-06 22:44:37'),
(20,'2','2','c81e728d9d4c2f636f067f89cc14862c','2019-07-06 23:43:36','2019-07-06 23:43:36'),
(24,'e','e','e1671797c52e15f763380b45e841ec32','2019-07-06 23:53:56','2019-07-06 23:53:56'),
(26,'admin','admin','e10adc3949ba59abbe56e057f20f883e','2019-07-07 22:11:43','2019-07-07 22:11:43');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `sur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表主键,自增',
  `sur_user_id` int(11) DEFAULT NULL COMMENT '用户表主键',
  `sur_role_id` int(11) DEFAULT NULL COMMENT '角色表主键',
  PRIMARY KEY (`sur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`sur_id`,`sur_user_id`,`sur_role_id`) values 
(1,1,1),
(4,4,2),
(5,24,1),
(6,27,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
