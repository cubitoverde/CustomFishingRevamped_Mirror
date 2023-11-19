package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.NewConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.FishingLootMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.GlobalLootCollectionItems;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.GlobalLootCollectionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.SelectNewGlobalLootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class ConditionalBuckets implements PageMenu {
    private Player player;

    public ConditionalBuckets(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();

        for (ConditionalBucket bucket : CustomFishingRevamped.conditionalBuckets) {
            Icon icon = new Icon(PluginUtils.GetConditionalBucketItem(bucket));
            // icon.addLAction(new OpenMenu(player, new GlobalLootCollectionItems(player, lootCollection)));
            // icon.addRAction(new OpenMenu(player, new GlobalLootCollectionSettings(player, lootCollection)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Conditional Loot]", 6*9,
                new FishingLootMenu(player), page, new NewConditionalBucket(), true, this);
    }
}
