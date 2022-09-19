package com.layer.demo.web;

import com.layer.demo.core.bo.UserBO;
import com.layer.demo.service.UserService;
import com.layer.demo.web.vo.UserVO;
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
    public UserVO addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        UserBO user = new UserBO();
        user.setName(name);
        user.setAge(age);
        UserBO userBO = userService.addUser(user);
        UserVO userVO = new UserVO();
        userVO.setName(userBO.getName());
        userVO.setAge(userBO.getAge());
        return userVO;
    }
}
