package com.layer.demo.service.impl;

import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.core.model.dataobject.UserDO;
import com.layer.demo.core.dao.UserMapper;
import com.layer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserBO.class, UserDO.class, false);

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserBO addUser(UserBO user) {
        UserDO userDO = new UserDO();
        copier.copy(userDO, user, null);

        Long id = userMapper.insert(userDO);
        user.setId(id);
        return user;
    }
}
