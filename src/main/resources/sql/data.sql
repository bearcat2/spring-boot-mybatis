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

/*Data for the table `sys_job` */

insert  into `sys_job`(`sj_id`,`sj_name`,`sj_group`,`sj_status`,`sj_cron_expression`,`sj_description`,`sj_bean_class`,`sj_spring_bean_name`,`sj_method_name`,`sj_create_time`,`sj_update_time`) values 
(1,'demo','systemJob',2,'0/5 * * * * ?','run',NULL,'demoJob','run','2019-07-14 22:38:11','2019-07-15 00:35:35');

/*Data for the table `sys_operate` */

insert  into `sys_operate`(`so_id`,`so_name`,`so_show_name`,`so_orderd`,`so_create_time`,`so_create_user`,`so_update_time`,`so_update_user`) values 
(4,'delete','删除',3,'2019-06-26 16:56:17','张三','2019-06-26 16:56:17','张三'),
(5,'detail','查看详情',4,'2019-06-26 16:57:07','张三','2019-06-26 16:57:07','张三'),
(6,'allotPrivilege','分配权限',5,'2019-06-26 16:57:51','张三','2019-06-26 16:57:51','张三'),
(12,'add','新增',1,'2019-06-28 21:37:51','张三','2019-06-28 21:37:51','张三'),
(13,'edit','编辑',2,'2019-06-28 21:38:02','张三','2019-06-28 21:38:36','张三'),
(14,'allotButton','分配按钮',6,'2019-07-13 17:16:56','张三','2019-07-13 17:16:56','张三');

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

/*Data for the table `sys_role` */

insert  into `sys_role`(`sr_id`,`sr_name`,`sr_description`,`sr_create_time`,`sr_update_time`) values 
(1,'管理员','拥有系统所有权限','2018-08-16 15:53:46','2018-08-16 15:53:48'),
(2,'普通用户','只拥有普通权限','2018-08-16 15:54:18','2018-08-17 20:43:00');

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

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_login_name`,`su_real_name`,`su_password`,`su_create_time`,`su_update_time`) values 
(1,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','2018-08-16 11:01:55','2019-07-07 22:22:02'),
(2,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','2018-08-16 15:52:44','2018-08-16 15:52:45'),
(4,'zzp','zzp','e10adc3949ba59abbe56e057f20f883e','2018-08-17 20:15:41','2018-08-17 20:15:41'),
(5,'wangwu','王五','123456','2019-05-06 22:44:37','2019-05-06 22:44:37'),
(20,'2','2','c81e728d9d4c2f636f067f89cc14862c','2019-07-06 23:43:36','2019-07-06 23:43:36'),
(24,'e','e','e1671797c52e15f763380b45e841ec32','2019-07-06 23:53:56','2019-07-06 23:53:56'),
(26,'admin','admin','e10adc3949ba59abbe56e057f20f883e','2019-07-07 22:11:43','2019-07-07 22:11:43');

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
