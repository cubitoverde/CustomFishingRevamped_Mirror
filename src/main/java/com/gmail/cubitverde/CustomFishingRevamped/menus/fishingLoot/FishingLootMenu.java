package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.ConditionalBuckets;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.GlobalLootCollections;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class FishingLootMenu implements Menu {
    private Player player;

    public FishingLootMenu(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.COD, ChatColor.GREEN + "Global loot"));
            icon.addAction(new OpenMenu(player, new GlobalLootCollections(player)));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.PUFFERFISH, ChatColor.GREEN + "Conditional loot"));
            icon.addAction(new OpenMenu(player, new ConditionalBuckets(player)));
            icons.put(15, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Fishing Loot]", 3*9, new MainMenu(player));
    }
}
