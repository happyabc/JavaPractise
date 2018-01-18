# maven配置文件pom增加变量取版本号

1.定义版本号

<properties>

  <spring.version>3.2.2.RELEASE</spring.version>

 </properties>

2.取版本号，方便以后架包版本升级

<dependency>

   <groupId>org.springframework</groupId>

   <artifactId>spring-core</artifactId>

   <version>${spring.version}</version>

  </dependency>

