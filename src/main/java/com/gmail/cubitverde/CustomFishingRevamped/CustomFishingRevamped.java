package com.gmail.cubitverde.CustomFishingRevamped;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.InventoryClick;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.EntityDamaged;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.PlayerChat;
import com.gmail.cubitverde.CustomFishingRevamped.listeners.PlayerFish;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class CustomFishingRevamped extends JavaPlugin {
    public static CustomFishingRevamped plugin;

    public static int dropId;
    public static int collectionId;
    public static int lootCollectionId;

    public static LinkedList<Collection> collections = new LinkedList<>();
    public static LinkedList<LootCollection> globalLootCollections = new LinkedList<>();

    public static List<Firework> dropFireworks = new ArrayList<>();

    public static Map<UUID, Speaker> speakers = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new InventoryClick(), plugin);
        getServer().getPluginManager().registerEvents(new PlayerChat(), plugin);
        getServer().getPluginManager().registerEvents(new PlayerFish(), plugin);
        getServer().getPluginManager().registerEvents(new EntityDamaged(), this);

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
