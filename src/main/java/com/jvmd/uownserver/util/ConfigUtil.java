package com.jvmd.uownserver.util;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigUtil {

   @Getter
   private static FileConfiguration config;

   public static void load(JavaPlugin plugin) {
       config = plugin.getConfig();
   }


}
