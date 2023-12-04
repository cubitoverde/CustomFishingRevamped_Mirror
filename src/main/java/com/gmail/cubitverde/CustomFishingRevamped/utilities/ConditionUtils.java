package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings.DeleteCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.RemoveBucketCondition;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionEnabled;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionWhitelist;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PermissionCondition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.TimeCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.BucketConditions;
import com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections.CollectionsList;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.Map;

public class ConditionUtils {
    public static LinkedList<Condition> GetAvailableConditions() {
        LinkedList<Condition> availableConditions = new LinkedList<>();

        availableConditions.add(new PlayersCondition());
        availableConditions.add(new PermissionCondition());
        availableConditions.add(new TimeCondition());

        return availableConditions;
    }

    public static ItemStack GetConditionInfoItem(Condition condition, boolean addDescription, boolean addSummary) {
        ItemStack itemStack = MiscUtils.CreateItem(condition.getIcon(), ChatColor.GREEN + condition.getName());
        if (addDescription) {
            for (String loreLine : condition.getDescription()) {
                MiscUtils.AddLore(itemStack, ChatColor.GRAY + loreLine);
            }
        }

        if (addSummary) {
            for (String loreLine : condition.getSummary()) {
                MiscUtils.AddLore(itemStack, loreLine);
            }
        }

        return itemStack;
    }

    public static ItemStack AddLootConditionInfoToItem(ItemStack itemStack, LootCondition lootCondition, boolean editable) {
        if (lootCondition.getWhitelist()) {
            MiscUtils.AddLore(itemStack, ChatColor.DARK_GREEN + "Mode: " + ChatColor.WHITE + "Whitelist");
        } else {
            MiscUtils.AddLore(itemStack, ChatColor.DARK_GREEN + "Mode: " + ChatColor.DARK_GRAY + "Blacklist");
        }

        if (lootCondition.getEnabled()) {
            MiscUtils.AddLore(itemStack, ChatColor.GREEN + "Enabled");
        } else {
            MiscUtils.AddLore(itemStack, ChatColor.RED + "Disabled");
        }

        if (editable) {
            MiscUtils.AddLore(itemStack, ChatColor.GRAY + "Click to open condition settings");
        }

        return itemStack;
    }

    public static Icon GetConditionSettingsEnableIcon(LootCondition lootCondition) {
        Icon icon;
        if (lootCondition.getEnabled()) {
            icon = new Icon(MiscUtils.CreateItem(Material.LIME_CONCRETE, ChatColor.GREEN + "Condition enabled",
                    ChatColor.GRAY + "Click to disable this condition"));
        } else {
            icon = new Icon(MiscUtils.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Condition disabled",
                    ChatColor.GRAY + "Click to enable this condition"));
        }
        icon.addAction(new ToggleLootConditionEnabled(lootCondition));

        return icon;
    }

    public static Icon GetConditionSettingsWhitelistIcon(LootCondition lootCondition) {
        Icon icon;
        if (lootCondition.getWhitelist()) {
            icon = new Icon(MiscUtils.CreateItem(Material.WHITE_CONCRETE, ChatColor.WHITE + "Whitelist mode",
                    ChatColor.GRAY + "Click to change to blacklist mode"));
        } else {
            icon = new Icon(MiscUtils.CreateItem(Material.BLACK_CONCRETE, ChatColor.DARK_GRAY + "Blacklist mode",
                    ChatColor.GRAY + "Click to change to whitelist mode"));
        }
        icon.addAction(new ToggleLootConditionWhitelist(lootCondition));

        return icon;
    }

    public static void AddBaseConditionSettingsIcons(Map<Integer, Icon> icons, Player player, LootCondition lootCondition, ConditionalBucket bucket,
                                                     int enableInt, int whitelistInt, int deleteInt, Menu thisMenu) {
        Condition condition = lootCondition.getCondition();
        {
            Icon icon = new Icon(ConditionUtils.AddLootConditionInfoToItem(ConditionUtils.GetConditionInfoItem(condition, true, false), lootCondition, false));
            icons.put(10, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsEnableIcon(lootCondition);
            icon.addAction(new OpenMenu(player, thisMenu));
            icons.put(enableInt, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsWhitelistIcon(lootCondition);
            icon.addAction(new OpenMenu(player, thisMenu));
            icons.put(whitelistInt, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.PAPER, ChatColor.GREEN + condition.getName(),
                    condition.getSummary()));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BARRIER, ChatColor.RED + "Delete condition",
                    ChatColor.DARK_RED + "Shift click to delete this condition"));
            icon.addShiftAction(new RemoveBucketCondition(bucket, lootCondition));
            icon.addShiftAction(new OpenMenu(player, new BucketConditions(player, bucket)));
            icons.put(deleteInt, icon);
        }
    }
}
