package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.BucketMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class BucketCollections implements PageMenu {
    private Player player;
    private ConditionalBucket bucket;

    public BucketCollections(Player player, ConditionalBucket bucket) {
        this.player = player;
        this.bucket = bucket;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();

        for (LootCollection lootCollection : bucket.getCollections()) {
            Icon icon = new Icon(PluginUtils.GetBucketCollectionItem(bucket, lootCollection));
            icon.addLAction(new OpenMenu(player, new BucketCollectionItems(player, bucket, lootCollection)));
            icon.addRAction(new OpenMenu(player, new BucketCollectionSettings(player, bucket, lootCollection)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Bucket Collections]", 6*9,
                new BucketMenu(player, bucket), page,
                new OpenMenu(player, new SelectNewBucketCollection(player, bucket)), false, this);
    }
}
