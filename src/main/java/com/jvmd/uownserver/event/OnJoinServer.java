package com.jvmd.uownserver.event;

import com.jvmd.uownserver.manager.Managers;
import com.jvmd.uownserver.model.EOwn;
import com.jvmd.uownserver.model.User;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinServer {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // todo check in db if null
        Managers.getUserOwnManager().addObject(User.builder().username(player.getName()).own(EOwn.GREEN).build());

    }
}
