package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollectionItem;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionsList;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.DropSettings;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class GlobalLootCollectionItems implements PageMenu {
    private Player player;
    private LootCollection lootCollection;

    public GlobalLootCollectionItems(Player player, LootCollection lootCollection) {
        this.player = player;
        this.lootCollection = lootCollection;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        Collection collection = lootCollection.getCollection();
        LinkedList<Icon> icons = new LinkedList<>();
        LinkedList<Drop> drops = collection.getItems();

        for (Drop drop : drops) {
            Icon icon = new Icon(PluginUtils.GetDropInfoItem(drop, collection));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Collection Items]", 6*9,
                new GlobalLootCollections(player), page, null, this);
    }
}
