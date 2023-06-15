# Prerequisite

------

## List essential software here

1. JDK 11

   Download JDK 11 from oracle website. Maybe you need register a accout.

   [Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/#java11-windows)

2. IntelliJ IDEA

   Download IDEA from JetBrains website. Community edition is enough. 

   ***You should modify maven setting according to Maven configuration below.***

   [IntelliJ IDEA ](https://www.jetbrains.com.cn/idea/download/#section=windows)

3. Maven

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

   Modify 

   ```properties
   # display Chinese in log console
   # java.util.logging.ConsoleHandler.encoding = UTF-8
   java.util.logging.ConsoleHandler.encoding = GBK
   ```

   [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)

5. Mysql

   Download Community Server is enough.

   [MySQL :: Download MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

6. postman

   postman client is first choice. 

   [Postman](https://www.postman.com/downloads/)

7. Navicat Premium(optional)

   The software only has 14-days trail.

   [Navicat Premium](https://www.navicat.com/en/download/navicat-premium)

   

   

