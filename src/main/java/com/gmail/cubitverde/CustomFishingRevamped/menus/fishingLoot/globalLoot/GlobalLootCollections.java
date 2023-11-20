package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.FishingLootMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class GlobalLootCollections implements PageMenu {
    private Player player;

    public GlobalLootCollections(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();

        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            Icon icon = new Icon(PluginUtils.GetGlobalLootCollectionItem(lootCollection));
            icon.addLAction(new OpenMenu(player, new GlobalLootCollectionItems(player, lootCollection)));
            icon.addRAction(new OpenMenu(player, new GlobalLootCollectionSettings(player, lootCollection)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Global Loot Collections]", 6*9,
                new FishingLootMenu(player), page, new OpenMenu(player, new SelectNewGlobalLootCollection(player)), false, this);
    }
}
