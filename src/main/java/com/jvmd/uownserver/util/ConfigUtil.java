package com.jvmd.uownserver.util;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class ConfigUtil {

   @Getter
   private static FileConfiguration config;
   @Getter
   private static BukkitScheduler scheduler;
   @Getter
   private static JavaPlugin p;


   public static void load(JavaPlugin plugin) {
       config = plugin.getConfig();
       scheduler = plugin.getServer().getScheduler();
       p = plugin;
   }



}
