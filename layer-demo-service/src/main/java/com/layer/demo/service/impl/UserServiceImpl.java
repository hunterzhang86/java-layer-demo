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
public class UserServiceImpl extends BaseUserService implements UserService {

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

    @Override
    public String mockPublicMethod(UserBO user) {
        return publicMethod(user);
    }

    public String publicMethod(UserBO user) {
        throw new UnsupportedOperationException("mockPublicMethod");
    }

    @Override
    public String mockFinalPublicMethod(UserBO user) {
        return finalPublicMethod(user);
    }

    public final String finalPublicMethod(UserBO user) {
        throw new UnsupportedOperationException("mockFinalPublicMethod");
    }

    @Override
    public String mockPrivateMethod(UserBO user) {
        return privateMethod(user);
    }

    private String privateMethod(UserBO user) {
        throw new UnsupportedOperationException("mockPrivateMethod");
    }

    @Override
    public String mockPublicStaticMethod(UserBO user) {
        return publicStaticMethod(user);
    }

    public static String publicStaticMethod(UserBO user) {
        throw new UnsupportedOperationException("mockPublicStaticMethod");
    }

    @Override
    public String mockPrivateStaticMethod(UserBO user) {
        return privateStaticMethod(user);
    }

    private static String privateStaticMethod(UserBO user) {
        throw new UnsupportedOperationException("mockPrivateStaticMethod");
    }

    @Override
    public String mockParentMethod(UserBO user) {
        return parentMethod(user);
    }
}
