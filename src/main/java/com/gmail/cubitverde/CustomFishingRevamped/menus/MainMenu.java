package com.gmail.cubitverde.CustomFishingRevamped.menus;

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
            Icon icon = new Icon(MiscUtils.CreateItem(Material.GRASS_BLOCK, ChatColor.GREEN + "Name"));
            // icon.addAction(new OpenMenu(player, MENU));
            icons.put(10, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Main Menu]", 4*9, null);
    }
}
