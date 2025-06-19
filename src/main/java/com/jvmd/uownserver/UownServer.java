package com.jvmd.uownserver;

import com.jvmd.uownserver.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.plugin.java.JavaPlugin;



@Slf4j
public final class UownServer extends JavaPlugin {

    @Override
    public void onEnable() {
        log.info("Starting UownServer...");
        ConfigUtil.load(this);
    }

    @Override
    public void onDisable() {
        log.info("Stopping UownServer...");
    }
}
