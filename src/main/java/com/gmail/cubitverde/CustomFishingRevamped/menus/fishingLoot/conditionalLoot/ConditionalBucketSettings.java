package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings.*;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.ChangeBucketName;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionChangingIcon;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionsList;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class ConditionalBucketSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;

    public ConditionalBucketSettings(Player player, ConditionalBucket bucket) {
        this.player = player;
        this.bucket = bucket;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(bucket.getIcon(), ChatColor.GREEN + bucket.getName()));
            icons.put(10, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Change name"));
            icon.addAction(new ChangeBucketName(player, bucket, this));
            icons.put(15, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.ITEM_FRAME, ChatColor.GREEN + "Change icon"));
            icon.addAction(new OpenMenu(player, new BucketChangingIcon(player, bucket)));
            icons.put(16, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Bucket Settings]", 3*9, new ConditionalBuckets(player));
    }
}
