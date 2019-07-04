# spring-boot-mybatis

#### 介绍
springboot整合mybatis实现通用的前端管理系统

#### 软件架构
spring boot + mybatis + pagehelper + thymeleaf


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
