package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.AddBucketCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.BucketCollections;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class SelectNewBucketCollection implements PageMenu {
    private Player player;
    private ConditionalBucket bucket;

    public SelectNewBucketCollection(Player player, ConditionalBucket bucket) {
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

        for (Collection collection : CustomFishingRevamped.collections) {
            Icon icon = new Icon(MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName(),
                    ChatColor.DARK_GREEN + "Click to add collection to the bucket"));
            icon.addAction(new AddBucketCollection(player, bucket, collection));
            icon.addAction(new OpenMenu(player, new BucketCollections(player, bucket)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Add Collection]", 6*9,
                new BucketCollections(player, bucket), page, null, this);
    }
}
