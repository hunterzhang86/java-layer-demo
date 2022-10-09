package com.layer.demo.service.impl;

import com.layer.demo.core.model.bo.UserBO;

public class BaseUserService {
    public String parentMethod(UserBO user) {
        throw new UnsupportedOperationException("mockParentMethod");
    }
}
