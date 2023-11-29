package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.BucketCollections;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.BucketConditions;
import com.gmail.cubitverde.CustomFishingRevamped.objects.*;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class PlayersConditionSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCondition lootCondition;

    public PlayersConditionSettings(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        this.player = player;
        this.bucket = bucket;
        this.lootCondition = lootCondition;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();
        Condition condition = lootCondition.getCondition();

        {
            Icon icon = new Icon(ConditionUtils.AddLootConditionInfoToItem(ConditionUtils.GetConditionInfoItem(condition, false), lootCondition, false));
            icons.put(10, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsEnableIcon(lootCondition);
            icon.addAction(new OpenMenu(player, this));
            icons.put(19, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsWhitelistIcon(lootCondition);
            icon.addAction(new OpenMenu(player, this));
            icons.put(20, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Condition Settings]", 4*9, new BucketConditions(player, bucket));
    }
}
