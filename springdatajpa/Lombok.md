# Lombok简单使用介绍

官网：https://projectlombok.org/


IDE中需要添加相应的插件


引入jar的pom
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.8</version>
</dependency>
```

几个常用的注解说明：

### @Setter
注解在类上，为所有属性添加set方法、注解在属性上为该属性提供set方法
### @Getter
注解在类上，为所有的属性添加get方法、注解在属性上为该属性提供get方法
### @ToString
创建一个toString方法  
@ToString(exclude=”id”)排除id属性，或者@ToString(callSuper=true, includeFieldNames=true)调用父类的toString方法，包含所有属性
### @NoArgsConstructor
创建一个无参构造函数
### @AllArgsConstructor
创建一个全参构造函数
### @Data
**等同于：@Setter @Getter @ToString @NoArgsConstructor**  
注解在类上，将类提供的所有属性都添加get、set方法，并添加、equals、canEquals、hashCode、toString、默认无参构造等方法

###@Log
根据不同的注解生成不同类型的log对象，但是实例名称都是log，有六种可选实现类

- @CommonsLog Creates log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);  

- @Log Creates log = java.util.logging.Logger.getLogger(LogExample.class.getName());  
- @Log4j Creates log = org.apache.log4j.Logger.getLogger(LogExample.class);  
- @Log4j2 Creates log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);  
- @Slf4j Creates log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
- @XSlf4j Creates log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);  

## 其他的去官网查看，不太推荐。
- @RequiredArgsConstructor 用来指定参数（采用静态方法of访问）：不建议使用，看源码会发现他用的是一个静态方法然后创建。  

- @EqualsAndHashCode  

- @NonNull  
- @Cleanup  
- @Value  
- @SneakyThrows  
- @Synchronized  
