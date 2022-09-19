package com.layer.demo.core.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;

/**
 * 应用配置管理
 *
 * @author zhanghuan
 */
@Data
public class AppConfigHolder {
    @NacosValue(value = "${app.name:demo}", autoRefreshed = true)
    private String appName;
}
