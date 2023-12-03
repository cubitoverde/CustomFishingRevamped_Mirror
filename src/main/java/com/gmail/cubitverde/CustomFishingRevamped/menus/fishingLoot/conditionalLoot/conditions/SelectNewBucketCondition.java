package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.AddNewConditionToBucket;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionDropsAmount;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionLuckModifier;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionWeight;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global.RemoveGlobalLootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.globalLoot.GlobalLootCollections;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SelectNewBucketCondition implements Menu {
    private Player player;
    private ConditionalBucket bucket;

    public SelectNewBucketCondition(Player player, ConditionalBucket bucket) {
        this.player = player;
        this.bucket = bucket;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        LinkedList<Condition> availableConditions = ConditionUtils.GetAvailableConditions();

        for (int i = 0; i < availableConditions.size(); i++) {
            Condition condition = availableConditions.get(i);
            Icon icon = new Icon(ConditionUtils.GetConditionInfoItem(condition, true, false));
            icon.addAction(new AddNewConditionToBucket(bucket, condition));
            icon.addAction(new OpenMenu(player, new BucketConditions(player, bucket)));
            icons.put(GuiUtils.InventoryInside(6*9).get(i), icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Available Conditions]", 6 * 9, new BucketConditions(player, bucket));
    }
}
