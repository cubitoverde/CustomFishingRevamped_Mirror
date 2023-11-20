package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.GlobalLootCollections;
import com.gmail.cubitverde.CustomFishingRevamped.objects.*;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class BucketCollectionItems implements PageMenu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCollection lootCollection;

    public BucketCollectionItems(Player player, ConditionalBucket bucket, LootCollection lootCollection) {
        this.player = player;
        this.bucket = bucket;
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
                new BucketCollections(player, bucket), page, null, this);
    }
}
