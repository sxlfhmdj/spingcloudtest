# Spirng Cloud
## Spring Cloud简介
&emsp;&emsp;Spring Cloud 是一个基于Spring Boot实现的微服务架构开发工具。它为微服务架构中涉及的配置管理、服务治理、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等操作提供了一种简单的开发方式。
## Spring Cloud Eureka
### 1、服务注册中心
```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka-server</artifactId>
        <version>1.3.1.RELEASE</version>
    </dependency>
</dependencies>
<dependencyManagement>
        <dependencies>
            <dependency>
                <!-- Import dependency management from Spring Cloud -->
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Brixton.SR5</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```



```
server.port=1111
eureka.instance.hostname=localhost
#由于应用是注册中心，所以设置为false，代表不向注册中心注册自己
eureka.client.register-with-eureka=false
#由于注册中心的职责就是维护服务实例，它并不需要去检索服务，所以也设置为false
eureka.client.fetch-registry=false
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

```


```
@Configuration
@EnableEurekaServer
@SpringBootApplication
@ComponentScan("org.xiaod.springcloud.eureka.server")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

```

### 2、服务提供者注册

```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka-server</artifactId>
        <version>1.3.1.RELEASE</version>
    </dependency>
</dependencies>
<dependencyManagement>
        <dependencies>
            <dependency>
                <!-- Import dependency management from Spring Cloud -->
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Brixton.SR5</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
</dependencyManagement>
```

```
server.port=1111
eureka.instance.hostname=localhost
#由于应用是注册中心，所以设置为false，代表不向注册中心注册自己
eureka.client.register-with-eureka=false
#由于注册中心的职责就是维护服务实例，它并不需要去检索服务，所以也设置为false
eureka.client.fetch-registry=false
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

```

```
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("org.xiaod.springcloud.eureka.client")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
```


### 3、高可用注册中心

## 参考文献
- Spring Cloud微服务实战