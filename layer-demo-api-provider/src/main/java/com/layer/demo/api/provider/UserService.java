package com.layer.demo.api.provider;


import com.layer.demo.api.dto.AddUserReqDTO;
import com.layer.demo.api.dto.AddUserRspDTO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    AddUserRspDTO addUser(AddUserReqDTO user);
}
