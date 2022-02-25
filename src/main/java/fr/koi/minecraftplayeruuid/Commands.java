package fr.koi.minecraftplayeruuid;

import fr.koi.minecraftplayeruuid.model.MinecraftPlayer;
import fr.koi.minecraftplayeruuid.service.MinecraftApi;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The plugin root command
 */
public class Commands implements CommandExecutor, TabCompleter {
    /**
     * The plugin
     */
    private final JavaPlugin plugin;

    /**
     * Create a new commands
     *
     * @param plugin The plugin
     */
    public Commands(final JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
        @NotNull CommandSender sender,
        @NotNull Command command,
        @NotNull String label,
        @NotNull String[] args
    ) {
        boolean error = false;

        if (sender.hasPermission("uuid.uuid")) {
            if (!(sender instanceof Player) || !"uuid".equalsIgnoreCase(command.getName())) {
                this.plugin.getServer().broadcastMessage(ChatColor.RED + "Invalid usage of /uuid command");
                error = true;
            } else if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "One argument required");
                error = true;
            } else if (args.length > 1) {
                sender.sendMessage(ChatColor.RED + "Only one argument required");
                error = true;
            } else {
                MinecraftPlayer minecraftPlayer = MinecraftApi.getMinecraftPlayerByName(args[0]);

                if (minecraftPlayer != null) {
                    sender.sendMessage("UUID of " + args[0] + " is : " + minecraftPlayer.getUUID());
                } else {
                    sender.sendMessage(ChatColor.RED + "Failed to fetch the UUID of player : " + args[0]);
                }
            }
        }

        return !error;
    }

    @Override
    public List<String> onTabComplete(
        final @NotNull CommandSender sender,
        final @NotNull Command command,
        final @NotNull String alias,
        final @NotNull String[] args
    ) {
        List<String> list = new ArrayList<>();

        if (sender.hasPermission("uuid.uuid") && args.length == 1) {
            this.plugin.getServer().getOnlinePlayers().forEach(player -> list.add(player.getName()));
        }

        return list;
    }
}
