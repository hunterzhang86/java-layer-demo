package com.layer.demo.core.converter;


import com.layer.demo.core.bo.UserBO;
import com.layer.demo.core.dao.dataobject.UserDO;
import org.junit.Assert;
import org.junit.Test;

public class UserConverterTest {

    @Test
    public void userDOToBO() {
        UserDO userDO = new UserDO();
        userDO.setName("boo");
        userDO.setId(100L);
        userDO.setAge(18);
        UserBO userBO = UserConverter.INSTANCE.doToBO(userDO);
        Assert.assertEquals(userBO.getName(), userDO.getName());
        Assert.assertEquals(userBO.getId(), userDO.getId());
        Assert.assertEquals(userBO.getAge(), userDO.getAge());
    }
}