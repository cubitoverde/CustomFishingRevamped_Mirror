package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.ChangeBucketName;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
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

public class BucketMenu implements Menu {
    private Player player;
    private ConditionalBucket bucket;

    public BucketMenu(Player player, ConditionalBucket bucket) {
        this.player = player;
        this.bucket = bucket;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.COMPARATOR, ChatColor.GREEN + "Bucket conditions"));
            // icon.addAction(new ChangeBucketName(player, bucket, this));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.CHEST, ChatColor.GREEN + "Bucket collections"));
            icon.addAction(new OpenMenu(player, new BucketCollections(player, bucket)));
            icons.put(15, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Bucket Menu]", 3*9, new ConditionalBuckets(player));
    }
}
