package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global.AddGlobalLootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionItems;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class SelectNewGlobalLootCollection implements PageMenu {
    private Player player;

    public SelectNewGlobalLootCollection(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();

        for (Collection collection : CustomFishingRevamped.collections) {
            Icon icon = new Icon(MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName(),
                    ChatColor.DARK_GREEN + "Click to add collection to global loot"));
            icon.addAction(new AddGlobalLootCollection(player, collection));
            icon.addAction(new OpenMenu(player, new GlobalLootCollections(player)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Add Collection]", 6*9,
                new GlobalLootCollections(player), page, null, this);
    }
}
