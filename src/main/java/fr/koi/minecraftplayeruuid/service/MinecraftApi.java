package fr.koi.minecraftplayeruuid.service;

import fr.koi.minecraftplayeruuid.model.MinecraftPlayer;

import java.io.IOException;
import java.net.URL;

/**
 * Service to manage minecraft public APIs
 */
public final class MinecraftApi {
    private MinecraftApi() {
    }

    /**
     * Get a minecraft player data with the specified pseudo
     *
     * @param pseudo The pseudo
     *
     * @return The player data (NULL if not found or HTTP/JSON error)
     */
    public static MinecraftPlayer getMinecraftPlayerByName(String pseudo) {
        MinecraftPlayer player = null;

        try {
            player = HttpService.get(
                new URL("https://api.mojang.com/users/profiles/minecraft/" + pseudo),
                MinecraftPlayer.class
            );
        } catch (IOException ignored) {
            // Nothing to do
        }

        return player;
    }
}
