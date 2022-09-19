package com.layer.demo.api.dto;

import lombok.Data;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
public class AddUserRspDTO {
    private Long id;

    private String name;

    private Integer age;
}