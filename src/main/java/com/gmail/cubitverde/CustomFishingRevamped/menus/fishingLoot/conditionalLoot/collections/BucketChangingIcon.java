package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.ChangeBucketIcon;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.ConditionalBucketSettings;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class BucketChangingIcon implements Menu {
    private Player player;
    private ConditionalBucket bucket;

    public BucketChangingIcon(Player player, ConditionalBucket bucket) {
        this.player = player;
        this.bucket = bucket;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        for (int i = 0; i < 36; i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null) {
                Icon icon = new Icon(MiscUtils.CreateItem(item.getType(), ChatColor.GREEN + item.getType().toString()));
                icon.addAction(new ChangeBucketIcon(bucket, item.getType()));
                icon.addAction(new OpenMenu(player, new ConditionalBucketSettings(player, bucket)));
                icons.put(i + 9, icon);
            } else {
                Icon icon = new Icon(MiscUtils.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
                icons.put(i + 9, icon);
            }
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Bucket Icon]", 6*9, new ConditionalBucketSettings(player, bucket));
    }
}
