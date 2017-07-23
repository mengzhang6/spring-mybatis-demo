本工程为Spring MVC与MyBatis整合的demo工程

需要注意以下几项：
1.注意JDK版本 jdk7
2.注意数据库配置（在spring-common.xml文件中配置）
3.注意Project Facets配置


第一种启动方式：tomcat启动
右键Run As -> Run On Server
测试路径：
http://127.0.0.1:8080/spring-mybatis-demo/user/getAll

第二种启动方式：jetty启动
在pom.xml路径下运行 mvn jetty:run -Djetty.port=9080
测试路径：
http://127.0.0.1:9080/user/getAll

