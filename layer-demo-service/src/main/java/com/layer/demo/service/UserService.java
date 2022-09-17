package com.layer.demo.service;


import com.layer.demo.bo.UserBO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserBO addUser(UserBO user);
}
