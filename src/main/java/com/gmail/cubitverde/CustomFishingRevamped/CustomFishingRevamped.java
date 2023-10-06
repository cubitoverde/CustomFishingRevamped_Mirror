package com.gmail.cubitverde.CustomFishingRevamped;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.InventoryClick;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.PlayerChat;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class CustomFishingRevamped extends JavaPlugin {
    public static CustomFishingRevamped plugin;

    public static int dropId;
    public static int collectionId;

    public static LinkedList<Collection> collections = new LinkedList<>();

    public static Map<UUID, Speaker> speakers = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new InventoryClick(), plugin);
        getServer().getPluginManager().registerEvents(new PlayerChat(), plugin);

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "This plugin can only be used by players.");
            return true;
        }
        Player player = (Player) sender;

        new OpenMenu(player, new MainMenu(player)).run();

        return true;
    }
}
