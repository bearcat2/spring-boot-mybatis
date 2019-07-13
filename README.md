# spring-boot-mybatis

#### 介绍
springboot整合mybatis实现通用的前端管理系统,该系统以RBAC(Resources-Based Access Control)基于资源的访问控制方式,实现权限管理。
- 使用通用mapper简化单表的CRUD操作,并引入代码生成器插件生成数据表对应的实体,mapper接口及对应的映射文件
- 使用springmvc拦截器实现了，用户登录拦截,在线用户权限动态刷新,用户权限校验等功能。
- 前端使用thymeleaf + Layui实现布局

#### 使用说明
- 代码生成器使用步骤
    - 添加代码生成器配置文件,具体参考resources/generator 目录下generatorConfig.xml文件,[配置项详细介绍参见](https://gitee.com/free/Mapper/wikis/4.1.mappergenerator?sort_id=236560)
    - pom文件添加如下插件
    ```
    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.6</version>
        <configuration>
            <configurationFile>
                ${basedir}/src/main/resources/generator/generatorConfig.xml
            </configurationFile>
            <overwrite>true</overwrite>
            <verbose>true</verbose>
        </configuration>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <dependency>
                <groupId>tk.mybatis</groupId>
                <artifactId>mapper-generator</artifactId>
                <version>1.1.5</version>
            </dependency>
        </dependencies>
    </plugin>
    ```
    - 配置代码生成器maven插件,输入`mybatis-generator:generate`运行插件即可生成相应代码
   

#### 软件架构
spring boot + mybatis + 通用mapper + pagehelper + redis + thymeleaf + layui

#### 安装教程

1. 创建数据库,通过数据库客户端导入 resources/sql目录下的table_data.sql脚本或放开application中的下面代码
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