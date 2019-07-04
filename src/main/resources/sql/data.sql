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

/*Data for the table `sys_operate` */

insert  into `sys_operate`(`so_id`,`so_name`,`so_show_name`,`so_orderd`,`so_create_time`,`so_create_user`,`so_update_time`,`so_update_user`) values 
(4,'delete','删除',3,'2019-06-26 16:56:17','张三','2019-06-26 16:56:17','张三'),
(5,'detail','查看详情',4,'2019-06-26 16:57:07','张三','2019-06-26 16:57:07','张三'),
(6,'allotPrivilege','分配权限',5,'2019-06-26 16:57:51','张三','2019-06-26 16:57:51','张三'),
(12,'add','新增',1,'2019-06-28 21:37:51','张三','2019-06-28 21:37:51','张三'),
(13,'edit','编辑',2,'2019-06-28 21:38:02','张三','2019-06-28 21:38:36','张三');

/*Data for the table `sys_privilege` */

insert  into `sys_privilege`(`sp_id`,`sp_name`,`sp_uri`,`sp_type`,`sp_operate_name`,`sp_parent_id`,`sp_orderd`,`sp_create_time`,`sp_update_time`) values 
(1,'用户管理','/sysUser/list',2,NULL,6,1,'2018-08-16 15:56:34','2019-06-16 22:16:14'),
(6,'系统管理','',1,NULL,0,6,'2018-08-17 18:33:01','2019-06-16 22:18:48'),
(8,'新增','/sysRole/add',3,'add',11,NULL,'2018-08-17 19:21:07','2018-08-17 19:21:16'),
(9,'修改','/sysRole/edit',3,'edit',11,NULL,'2018-08-17 19:21:09','2018-08-17 19:21:14'),
(10,'删除','/sysRole/delete',3,'delete',11,NULL,'2018-08-17 19:21:10','2018-08-17 19:21:18'),
(11,'角色管理','/sysRole/list',2,NULL,6,2,'2018-08-17 19:21:32','2018-08-17 19:21:20'),
(12,'菜单管理','/sysMenu/list',2,NULL,6,3,'2018-08-17 19:21:34','2018-08-17 19:21:23'),
(14,'新增','/sysMenu/add',3,'add',12,NULL,'2018-08-17 19:21:38','2018-08-17 19:21:28'),
(15,'修改','/sysMenu/edit',3,'edit',12,NULL,'2018-08-17 19:21:40','2018-08-17 19:21:30'),
(16,'删除','/sysMenu/delete',3,'delete',12,NULL,'2018-08-17 19:21:42','2018-08-17 19:21:44'),
(18,'分配权限','/sysMenu/allotPrivilege',3,'allotPrivilege',11,NULL,'2018-08-17 21:32:52','2018-08-17 21:32:54'),
(20,'按钮管理','/sysOperate/list',2,NULL,6,4,'2019-06-26 15:44:52','2019-06-26 17:01:12'),
(46,'编辑','/sysUser/edit',3,'edit',1,NULL,'2019-07-01 23:09:29','2019-07-01 23:09:29'),
(94,'查看详情','/sysUser/detail',3,'detail',1,NULL,'2019-07-01 23:54:09','2019-07-01 23:54:09'),
(95,'新增','/sysUser/add',3,'add',1,NULL,'2019-07-01 23:55:26','2019-07-01 23:55:26'),
(96,'删除','/sysUser/delete',3,'delete',1,NULL,'2019-07-01 23:55:26','2019-07-01 23:55:26');

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
(339,1,6),
(340,1,1),
(341,1,46),
(344,1,94),
(345,1,11),
(346,1,8),
(347,1,9),
(348,1,10),
(349,1,18),
(350,1,12),
(351,1,14),
(352,1,15),
(353,1,16),
(354,1,20);

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_login_name`,`su_real_name`,`su_password`,`su_create_time`,`su_update_time`) values 
(1,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','2018-08-16 11:01:55','2018-08-16 11:01:55'),
(2,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','2018-08-16 15:52:44','2018-08-16 15:52:45'),
(4,'zzp','zzp','e10adc3949ba59abbe56e057f20f883e','2018-08-17 20:15:41','2018-08-17 20:15:41'),
(5,'wangwu','王五','123456','2019-05-06 22:44:37','2019-05-06 22:44:37'),
(19,'dadsasd','dadsad','8f4031bfc7640c5f267b11b6fe0c2507','2019-06-16 17:55:11','2019-06-16 17:55:11');

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`sur_id`,`sur_user_id`,`sur_role_id`) values 
(1,1,1),
(4,4,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
