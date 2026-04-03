package com.jvmd.uownserver.config;

import com.jvmd.uownserver.util.ConfigUtil;
import lombok.Getter;


public final class PluginConfig {

    @Getter
    private static final ServerConfig serverConfig;

    static {
        serverConfig = new ServerConfig(ConfigUtil.getConfig().getString("host"),ConfigUtil.getConfig().getInt("port"),ConfigUtil.getConfig().getString("password"), ConfigUtil.getConfig().getString("trustedIp"));
    }

}
