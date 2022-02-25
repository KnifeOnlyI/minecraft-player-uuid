package fr.koi.minecraftplayeruuid;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * The main class of plugin
 */
public final class MinecraftPlayerUuid extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("uuid")).setExecutor(new Commands(this));
    }

    @Override
    public void onDisable() {
        // Nothing to do
    }
}
