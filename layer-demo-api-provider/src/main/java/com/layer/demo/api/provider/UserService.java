package com.layer.demo.api.provider;


import com.layer.demo.api.dto.UserDTO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserDTO addUser(UserDTO user);
}
