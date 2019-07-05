# spring-boot-mybatis

#### 介绍
springboot整合mybatis实现通用的前端管理系统,该系统以RBAC(Resources-Based Access Control)基于资源的访问控制方式,实现权限管理。
使用springmvc拦截器实现了，用户登录拦截,在线用户权限动态刷新,用户权限校验等功能。前端使用thymeleaf + Layui实现布局。

#### 软件架构
spring boot + mybatis + pagehelper + redis + thymeleaf + layui

#### 安装教程

1. 创建数据库,通过数据库客户端导入 resources目录下sql目录下的table_data.sql脚本或放开application中的下面代码
   ```  
    # 指定建表脚本所在目录
    schema: classpath:sql/table.sql
    # 指定数据脚本所在目录
    data: classpath:sql/data.sql
    # springboot2.x设置该属性才会执行脚本
    initialization-mode: always
    
    注意
    1. 建表脚本和数据脚本不能包含 create database xxx 建库语句,否则报错
    2. 以上配置只需在表和数据有变化时执行即可,无需每次启动执行
   ```
2. 安装redis服务器,并修改全局配置文件中redis相关配置,redis 服务器已上传至附件，为了便于测试已同步上传了windows版本redis服务器
