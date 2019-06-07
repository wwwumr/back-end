# Service Discovery
用Eureka Server来实现服务发现与服务注册

## client端设置
首先在pom中加入依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

然后在client的配置文件中，比如application.properties中加入配置
```
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

当然，这是在设置eureka server在8761端口运行之后才这样写的，这样在服务运行起来之后就会去server那里注册了

