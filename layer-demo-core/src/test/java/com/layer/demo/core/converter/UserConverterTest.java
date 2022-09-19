package com.layer.demo.core.converter;


import com.layer.demo.api.dto.AddUserReqDTO;
import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.core.model.dataobject.UserDO;
import org.junit.Assert;
import org.junit.Test;

public class UserConverterTest {

    @Test
    public void testDOToBO() {
        UserDO userDO = new UserDO();
        userDO.setName("boo");
        userDO.setId(100L);
        userDO.setAge(18);
        UserBO userBO = UserConverter.INSTANCE.doToBO(userDO);
        Assert.assertEquals(userBO.getName(), userDO.getName());
        Assert.assertEquals(userBO.getId(), userDO.getId());
        Assert.assertEquals(userBO.getAge(), userDO.getAge());
    }

    @Test
    public void testDTOtoBO() {
        AddUserReqDTO userDTO = new AddUserReqDTO();
        userDTO.setName("boo");
        userDTO.setId(100L);
        userDTO.setAge(18);
        UserBO userBO = UserConverter.INSTANCE.dtoToBO(userDTO);
        Assert.assertEquals(userBO.getName(), userDTO.getName());
        Assert.assertEquals(userBO.getId(), userDTO.getId());
        Assert.assertEquals(userBO.getAge(), userDTO.getAge());
    }
}