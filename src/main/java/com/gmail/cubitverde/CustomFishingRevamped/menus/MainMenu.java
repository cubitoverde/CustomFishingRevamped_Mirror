package com.gmail.cubitverde.CustomFishingRevamped.menus;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.LootCollections;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements Menu {
    private Player player;

    public MainMenu(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.TROPICAL_FISH, ChatColor.GREEN + "Fishing loot"));
            // icon.addAction(new OpenMenu(player, MENU));
            icons.put(10, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.CHEST, ChatColor.GREEN + "Loot collections"));
            icon.addAction(new OpenMenu(player, new LootCollections(player)));
            icons.put(12, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.FISHING_ROD, ChatColor.GREEN + "Fishing settings"));
            // icon.addAction(new OpenMenu(player, MENU));
            icons.put(14, icon);
        }  {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Plugin settings"));
            // icon.addAction(new OpenMenu(player, MENU));
            icons.put(16, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Main Menu]", 3*9, null);
    }
}
