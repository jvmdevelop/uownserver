package com.jvmd.uownserver.model;

import net.Indyuce.mmocore.api.player.PlayerData;
import net.Indyuce.mmocore.experience.EXPSource;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public enum DonateType {
    LEVEL_UP() {
        @Override
        public void give(@NotNull Player player) {
            PlayerData data = PlayerData.get(player);
            data.giveLevels(1, EXPSource.OTHER);
        }
    },
    ATTRIBUTE_UP() {
        @Override
        public void give(@NotNull Player player) {
            PlayerData data = PlayerData.get(player);
            data.giveAttributePoints(1);
        }
    },
    CHANGE_CLASS() {
        @Override
        public void give(@NotNull Player player) {
            PlayerData data = PlayerData.get(player);
            data.giveClassPoints(1);
        }
    }
    ;

    public abstract void give(@NotNull Player player);
}
