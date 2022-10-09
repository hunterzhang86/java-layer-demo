# 前置步骤

## 引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.powermock</groupId>
        <artifactId>powermock-module-junit4</artifactId>
        <version>2.0.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.powermock</groupId>
        <artifactId>powermock-api-mockito2</artifactId>
        <version>2.0.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 增加覆盖率扫描插件

项目需要被扫描到，需要在项目外层 pom 文件添加如下配置：

```xml
<profiles>
    <profile>
        <id>coverage</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.jacoco</groupId>
                    <artifactId>jacoco-maven-plugin</artifactId>
                    <version>0.8.4</version>
                    <executions>
                        <execution>
                            <id>prepare-agent</id>
                            <goals>
                                <goal>prepare-agent</goal>
                            </goals>
                        </execution>
                        <execution>
                            <id>report</id>
                            <goals>
                                <goal>report</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </profile>
</profiles>
```

# 常见示例

## Mock 类自己的公有方法

```java
@Test
public void testMockPublicMethod(){
    UserServiceImpl userService1=PowerMockito.spy(userServiceImpl);
    PowerMockito.doReturn("mockPublicMethod").when(userService1).publicMethod(any());
    String result=userService1.mockPublicMethod(new UserBO());
    Assert.assertEquals("mockPublicMethod",result);
}
```

## Mock 类自己的 Final 公有方法

```java
@Test    
public void testMockPublicFinalMethod(){
    UserServiceImpl userService1=PowerMockito.spy(userServiceImpl);
    PowerMockito.doReturn("mockFinalPublicMethod").when(userService1).finalPublicMethod(any());
    String result=userService1.mockFinalPublicMethod(new UserBO());
    Assert.assertEquals("mockFinalPublicMethod",result);
}  
```

## Mock 类自己的私有方法

```java
@Test
public void testMockPrivateMethod()throws Exception{
    UserServiceImpl userService1=PowerMockito.spy(userServiceImpl);
    PowerMockito.doReturn("mockPrivateMethod").when(userService1,"privateMethod",any());

    String result=userService1.mockPrivateMethod(new UserBO());
    Assert.assertEquals("mockPrivateMethod",result);
}
```

## Mock 类自己的私有静态方法

```java
@Test
public void testMockPrivateStaticMethod()throws Exception{
    PowerMockito.mockStatic(UserServiceImpl.class);
    PowerMockito.doReturn("mockPrivateStaticMethod").when(UserServiceImpl.class,"privateStaticMethod",any());

    String result=userServiceImpl.mockPrivateStaticMethod(new UserBO());
    Assert.assertEquals("mockPrivateStaticMethod",result);
}
```

## Mock 类自己的公有静态方法

```java
@Test
public void testMockPublicStaticMethod(){
    PowerMockito.mockStatic(UserServiceImpl.class);
    PowerMockito.when(UserServiceImpl.publicStaticMethod(any())).thenReturn("mockPublicStaticMethod");

    String result=userServiceImpl.mockPublicStaticMethod(new UserBO());
    Assert.assertEquals("mockPublicStaticMethod",result);
}
```

## Mock 父类的方法
```java
@Test
public void testMockParentMethod() {
    UserServiceImpl userService1 = PowerMockito.spy(userServiceImpl);
    PowerMockito.doReturn("mockParentMethod").when(userService1).parentMethod(any());

    String result = userService1.mockParentMethod(new UserBO());
    Assert.assertEquals("mockParentMethod", result);
}
```

## Mock 依赖的对象方法
```java
@Test
public void testMockMapper() {
    UserDO userDO = new UserDO();
    userDO.setName("mockMapper");
    PowerMockito.when(userMapper.getById(anyLong())).thenReturn(userDO);
    String result = userServiceImpl.getUserName(1000L);
    Assert.assertEquals("mockMapper", result);
}
```


# 结论
以上代码都可以在 [powermock-demo](https://github.com/hunterzhang86/java-layer-demo/blob/master/layer-demo-service/src/test/java/com/layer/demo/service/impl/UserServiceImplTest.java) 中找到。
