package com.layer.demo.web;

import com.layer.demo.api.dto.AddUserReqDTO;
import com.layer.demo.api.dto.AddUserRspDTO;
import com.layer.demo.core.converter.UserConverter;
import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/username")
    public String getUserName(@RequestParam("id") Long id) {
        return userService.getUserName(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public AddUserRspDTO addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        AddUserReqDTO user = new AddUserReqDTO();
        user.setName(name);
        user.setAge(age);
        UserBO userBO = userService.addUser(UserConverter.INSTANCE.dtoToBO(user));
        AddUserRspDTO userRspDTO = new AddUserRspDTO();
        userRspDTO.setName(userBO.getName());
        userRspDTO.setAge(userBO.getAge());
        return userRspDTO;
    }
}
