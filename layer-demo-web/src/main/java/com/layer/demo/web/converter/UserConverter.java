package com.layer.demo.web.converter;

import com.layer.demo.core.model.bo.UserBO;
import com.layer.demo.web.vo.UserVO;
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
     * @param source BO
     * @return VO
     */
    UserVO boToVO(UserBO source);
}

