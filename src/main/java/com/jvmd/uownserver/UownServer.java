package com.jvmd.uownserver;

import com.jvmd.uownserver.controller.impl.UserOwnController;
import com.jvmd.uownserver.event.OnKillListener;
import com.jvmd.uownserver.manager.abs.UserOwnManager;
import com.jvmd.uownserver.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;


@Slf4j
public final class UownServer extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigUtil.load(this);
        log.info("Starting UownServer...");
        getServer().getPluginManager().registerEvents(new OnKillListener(), this);
        new UserOwnController();
    }

    @Override
    public void onDisable() {
        log.info("Stopping UownServer...");
    }
}
