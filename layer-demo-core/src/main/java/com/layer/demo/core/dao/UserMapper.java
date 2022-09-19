package com.layer.demo.core.dao;

import com.layer.demo.core.model.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表操作类
 *
 * @author zhanghuan
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名获取用户
     *
     * @param name 用户名
     * @return 用户信息
     */
    UserDO getByName(String name);

    /**
     * 根据用户 ID 获取用户
     *
     * @param id 用户 ID
     * @return 用户信息
     */
    UserDO getById(Long id);

    /**
     * 插入用户
     *
     * @param userDO 用户
     * @return 用户信息
     */
    Long insert(UserDO userDO);
}
