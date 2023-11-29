package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionEnabled;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionWhitelist;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.BucketMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.BucketCollectionItems;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.BucketCollectionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.SelectNewBucketCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class BucketConditions implements PageMenu {
    private Player player;
    private ConditionalBucket bucket;

    public BucketConditions(Player player, ConditionalBucket bucket) {
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

        for (LootCondition lootCondition : bucket.getConditions()) {
            Condition condition = lootCondition.getCondition();
            Icon icon = new Icon(ConditionUtils.AddLootConditionInfoToItem(ConditionUtils.GetConditionInfoItem(condition, false), lootCondition, true));
            icon.addAction(new OpenMenu(player, condition.getSettingsMenu(player, bucket, lootCondition)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Bucket Conditions]", 6*9,
                new BucketMenu(player, bucket), page,
                new OpenMenu(player, new SelectNewBucketCondition(player, bucket)), false, this);
    }
}
