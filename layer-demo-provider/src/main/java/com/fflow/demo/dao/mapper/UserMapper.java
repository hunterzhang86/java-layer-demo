package com.layer.demo.demo.dao.mapper;

import com.layer.demo.demo.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Mapper
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);

    Long insert(UserDO userDO);
}
