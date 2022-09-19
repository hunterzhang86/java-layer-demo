package com.layer.demo.web.converter;

import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.web.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;

public class UserConverterTest {

    @Test
    public void boToVO() {
        UserBO userBO = new UserBO();
        userBO.setName("boo");
        userBO.setId(100L);
        userBO.setAge(18);
        UserVO userVO = UserConverter.INSTANCE.boToVO(userBO);
        Assert.assertEquals(userVO.getName(), userBO.getName());
        Assert.assertEquals(userVO.getId(), userBO.getId());
        Assert.assertEquals(userVO.getAge(), userBO.getAge());
    }
}