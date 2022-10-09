package com.layer.demo.service.impl;

import com.layer.demo.core.dao.UserMapper;
import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.core.model.dataobject.UserDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
        UserServiceImpl.class,
        UserMapper.class,
})
public class UserServiceImplTest {
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Mock 类自己的公有方法
     */
    @Test
    public void testMockPublicMethod() {
        UserServiceImpl userService1 = PowerMockito.spy(userServiceImpl);
        PowerMockito.doReturn("mockPublicMethod").when(userService1).publicMethod(any());
        String result = userService1.mockPublicMethod(new UserBO());
        Assert.assertEquals("mockPublicMethod", result);
    }

    /**
     * Mock 类自己的 Final 公有方法
     */
    @Test
    public void testMockPublicFinalMethod() {
        UserServiceImpl userService1 = PowerMockito.spy(userServiceImpl);
        PowerMockito.doReturn("mockFinalPublicMethod").when(userService1).finalPublicMethod(any());
        String result = userService1.mockFinalPublicMethod(new UserBO());
        Assert.assertEquals("mockFinalPublicMethod", result);
    }

    /**
     * Mock 类自己的私有方法
     */
    @Test
    public void testMockPrivateMethod() throws Exception {
        UserServiceImpl userService1 = PowerMockito.spy(userServiceImpl);
        PowerMockito.doReturn("mockPrivateMethod").when(userService1, "privateMethod", any());

        String result = userService1.mockPrivateMethod(new UserBO());
        Assert.assertEquals("mockPrivateMethod", result);
    }

    /**
     * Mock 类自己的私有静态方法
     */
    @Test
    public void testMockPrivateStaticMethod() throws Exception {
        PowerMockito.mockStatic(UserServiceImpl.class);
        PowerMockito.doReturn("mockPrivateStaticMethod").when(UserServiceImpl.class, "privateStaticMethod", any());

        String result = userServiceImpl.mockPrivateStaticMethod(new UserBO());
        Assert.assertEquals("mockPrivateStaticMethod", result);
    }

    /**
     * Mock 类自己的公有静态方法
     */
    @Test
    public void testMockPublicStaticMethod() {
        PowerMockito.mockStatic(UserServiceImpl.class);
        PowerMockito.when(UserServiceImpl.publicStaticMethod(any())).thenReturn("mockPublicStaticMethod");

        String result = userServiceImpl.mockPublicStaticMethod(new UserBO());
        Assert.assertEquals("mockPublicStaticMethod", result);
    }

    /**
     * Mock 父类的方法
     */
    @Test
    public void testMockParentMethod() {
        UserServiceImpl userService1 = PowerMockito.spy(userServiceImpl);
        PowerMockito.doReturn("mockParentMethod").when(userService1).parentMethod(any());

        String result = userService1.mockParentMethod(new UserBO());
        Assert.assertEquals("mockParentMethod", result);
    }

    /**
     * Mock 依赖的对象方法
     */
    @Test
    public void testMockMapper() {
        UserDO userDO = new UserDO();
        userDO.setName("mockMapper");
        PowerMockito.when(userMapper.getById(anyLong())).thenReturn(userDO);
        String result = userServiceImpl.getUserName(1000L);
        Assert.assertEquals("mockMapper", result);
    }
}