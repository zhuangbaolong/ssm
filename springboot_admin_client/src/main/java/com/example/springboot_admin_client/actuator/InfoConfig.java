package com.example.springboot_admin_client.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        //动态数据处理配置显示
        builder.withDetail("runTime",System.currentTimeMillis());
        Map infoMap = new HashMap();
        infoMap.put("buildTime","2023-9-3");
        builder.withDetails(infoMap);
    }
}
