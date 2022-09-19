package com.layer.demo.core.converter;

import com.layer.demo.api.dto.AddUserReqDTO;
import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.core.model.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户对象转换器
 *
 * @author zhanghuan
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * 转换
     *
     * @param source DO
     * @return BO
     */
    UserBO doToBO(UserDO source);

    /**
     * 转换
     *
     * @param source DTO
     * @return BO
     */
    UserBO dtoToBO(AddUserReqDTO source);
}

