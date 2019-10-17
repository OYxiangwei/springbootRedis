# springbootRedis
springboot_Redis整合
1、修改 pom.xml，添加依赖spring-boot-starter-data-redis
2、在resources中的 application.properties 配置Redis
3、新建RedisUtil工具类，用来封装一些 redis 的基本操作，用StringRedisTemplate
4、新建 SpringBoot 启动类RedisApplication.java
5、新建一个单元测试类，用于测试我们的工具类能否正常运行
