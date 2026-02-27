package com.jvmd.uownserver.event;

import com.jvmd.uownserver.manager.Managers;
import com.jvmd.uownserver.model.Donate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Donate donate = Managers.getDonateManager().findDonateByNickname(event.getPlayer().getName());
        if (donate == null) return;
        donate.getType().give(event.getPlayer());
    }
}
