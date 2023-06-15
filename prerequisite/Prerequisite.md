# Prerequisite

## List essential software here

1. JDK 11

   Download JDK 11 from oracle website. Maybe you need register a accout.

   [Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/#java11-windows)

2. IntelliJ IDEA

   Download IDEA from JetBrains website. Community edition is enough. 

   ***You should modify maven setting in idea according to Maven configuration below.***

   [IntelliJ IDEA ](https://www.jetbrains.com.cn/idea/download/#section=windows)

3. Maven

   The version used is 3.9.2.

   Modify conf/settings.xml

   ```xml
   <!-- Local storage path -->
   <localRepository>D:\maven\repository</localRepository>  
   <mirrors>
   <!-- for download speed -->
   	<mirror>
         <id>alimaven</id>
         <name>aliyun maven</name>
         <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
         <mirrorOf>central</mirrorOf>
       </mirror>
   </mirrors>
   <!-- match with jdk11 -->
   </profiles>
   	<profile>    
   		<id>jdk-11</id>    
   		 <activation>    
   			<activeByDefault>true</activeByDefault>    
   			<jdk>11</jdk>    
   		 </activation>    
   		<properties>    
   			<maven.compiler.source>11</maven.compiler.source>    
   			<maven.compiler.target>11</maven.compiler.target>    
   			<maven.compiler.compilerVersion>11</maven.compiler.compilerVersion>    
   		</properties>    
   	</profile>
   </profiles>
   ```

   [Maven](https://maven.apache.org/download.cgi)

4. Tomcat

   The version used is  9.0.76

   Modify  conf/logging.properties

   ```properties
   # display Chinese in log console
   # java.util.logging.ConsoleHandler.encoding = UTF-8
   java.util.logging.ConsoleHandler.encoding = GBK
   ```

   [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)

5. Mysql

   Download Community Server is enough. The version used is 8.0.33.

   [MySQL :: Download MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

   New a file which named my.ini inside decompressed folder.

   ```ini
   [mysqld]
   # 设置3306端口
   port=3306
   # 设置mysql的安装目录
   basedir=D:\Program Files\MySQL
   # 设置mysql数据库的数据的存放目录
   datadir=D:\Program Files\MySQL\Data
   # 允许最大连接数
   max_connections=200
   # 允许连接失败的次数。
   max_connect_errors=10
   # 服务端使用的字符集默认为utf8mb4
   character-set-server=utf8mb4
   # 创建新表时将使用的默认存储引擎
   default-storage-engine=INNODB
   # 默认使用“mysql_native_password”插件认证
   #mysql_native_password
   default_authentication_plugin=mysql_native_password
   [mysql]
   # 设置mysql客户端默认字符集
   default-character-set=utf8mb4
   [client]
   # 设置mysql客户端连接服务端时默认使用的端口
   port=3306
   default-character-set=utf8mb4
   ```

   Run cmd as administrator. Execute Command:

   ```
   D:\Program Files\mysql-8.0.33\bin>mysqld --initialize --console
   2023-06-15T07:52:36.385224Z 0 [Warning] [MY-010918] [Server] 'default_authentication_plugin' is deprecated and will be removed in a future release. Please use authentication_policy instead.
   2023-06-15T07:52:36.385236Z 0 [System] [MY-013169] [Server] D:\Program Files\mysql-8.0.33\bin\mysqld.exe (mysqld 8.0.33) initializing of server in progress as process 9048
   2023-06-15T07:52:36.385306Z 0 [ERROR] [MY-010338] [Server] Can't find error-message file 'D:\Program Files\MySQL\share\errmsg.sys'. Check error-message file location and 'lc-messages-dir' configuration directive.
   2023-06-15T07:52:36.395322Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
   2023-06-15T07:52:36.602700Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
   2023-06-15T07:52:36.988742Z 0 [Warning] [MY-013829] [Server] Missing data directory for ICU regular expressions: D:\Program Files\MySQL\lib\private\.
   2023-06-15T07:52:37.192823Z 6 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: XXXXXXXX
   
   D:\Program Files\mysql-8.0.33\bin>mysqld --install
   Service successfully installed.
   
   D:\Program Files\mysql-8.0.33\bin>net start mysql
   MySQL 服务正在启动 .
   MySQL 服务已经启动成功。
   ```

6. postman

   postman client is first choice. 

   [Postman](https://www.postman.com/downloads/)

7. Navicat Premium(optional)

   *The software has 14-days trail.*

   [Navicat Premium](https://www.navicat.com/en/download/navicat-premium)

   

   

