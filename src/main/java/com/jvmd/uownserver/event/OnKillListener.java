package com.jvmd.uownserver.event;

import com.jvmd.uownserver.manager.Managers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.EventListener;

public class OnKillListener implements Listener {


    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player p = e.getEntity().getKiller();
        assert p != null;
        Managers.getUserKillsManager().addKill(p.getName());
    }

}
