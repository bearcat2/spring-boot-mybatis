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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_login_name`,`su_real_name`,`su_password`,`su_create_time`,`su_update_time`) values 
(1,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','2018-08-16 11:01:55','2018-08-16 11:01:55'),
(2,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','2018-08-16 15:52:44','2018-08-16 15:52:45'),
(4,'zzp','zzp','e10adc3949ba59abbe56e057f20f883e','2018-08-17 20:15:41','2018-08-17 20:15:41'),
(5,'wangwu','王五','123456','2019-05-06 22:44:37','2019-05-06 22:44:37'),
(6,'wangwu','王五','123456','2019-05-06 23:20:42','2019-05-06 23:20:42');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
