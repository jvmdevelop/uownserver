package com.jvmd.uownserver.event;

import com.jvmd.uownserver.util.ConfigUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RollListener implements Listener {

    private static final long DOUBLE_PRESS_WINDOW = 300L;
    private static final int ROLL_DURATION_TICKS = 10;
    private static final double ROLL_FORCE = 1.2;

    private final Map<UUID, Long> lastShiftPress = new HashMap<>();
    private final Map<UUID, Boolean> rolling = new HashMap<>();

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (!e.isSneaking()) return;
        if (!p.isOnGround()) return;
        if (rolling.getOrDefault(p.getUniqueId(), false)) return;

        long now = System.currentTimeMillis();
        long last = lastShiftPress.getOrDefault(p.getUniqueId(), 0L);

        if (now - last <= DOUBLE_PRESS_WINDOW) {
            roll(p);
        } else {
            lastShiftPress.put(p.getUniqueId(), now);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID id = e.getPlayer().getUniqueId();
        lastShiftPress.remove(id);
        rolling.remove(id);
    }

    private void roll(Player p) {
        UUID id = p.getUniqueId();
        rolling.put(id, true);

        Vector direction = p.getLocation().getDirection().setY(0).normalize().multiply(ROLL_FORCE);
        p.setVelocity(direction);
        p.setNoDamageTicks(ROLL_DURATION_TICKS);

        ConfigUtil.getScheduler().scheduleSyncDelayedTask(ConfigUtil.getP(), () -> {
            rolling.remove(id);
            lastShiftPress.remove(id);
        }, ROLL_DURATION_TICKS);
    }

}
