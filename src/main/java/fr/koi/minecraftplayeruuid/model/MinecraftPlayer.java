package fr.koi.minecraftplayeruuid.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represent a minecraft player data
 */
public class MinecraftPlayer {
    /**
     * The UUID
     */
    private String uuid;

    /**
     * The name
     */
    private String name;

    /**
     * Create a new minecraft player data
     *
     * @param uuid The UUID
     * @param name The name
     */
    public MinecraftPlayer(@JsonProperty("id") String uuid, @JsonProperty("name") String name) {
        this.uuid = uuid;
        this.name = name;
    }

    /**
     * Get the value of : id
     *
     * @return id
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Set value of : id
     *
     * @param uuid The new value
     *
     * @return this
     */
    public MinecraftPlayer setUUID(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * Get the value of : name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set value of : name
     *
     * @param name The new value
     *
     * @return this
     */
    public MinecraftPlayer setName(String name) {
        this.name = name;
        return this;
    }
}
