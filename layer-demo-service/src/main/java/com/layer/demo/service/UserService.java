package com.layer.demo.service;


import com.layer.demo.core.model.bo.UserBO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserBO addUser(UserBO user);

    String mockPublicMethod(UserBO user);

    String mockPrivateMethod(UserBO user);

    String mockPrivateStaticMethod(UserBO user);

    String mockParentMethod(UserBO user);

    String mockPublicStaticMethod(UserBO user);

    String mockFinalPublicMethod(UserBO user);
}
