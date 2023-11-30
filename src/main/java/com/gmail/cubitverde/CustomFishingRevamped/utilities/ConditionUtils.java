package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionEnabled;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.ToggleLootConditionWhitelist;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;

public class ConditionUtils {
    public static LinkedList<Condition> GetAvailableConditions() {
        LinkedList<Condition> availableConditions = new LinkedList<>();

        availableConditions.add(new PlayersCondition());

        return availableConditions;
    }

    public static ItemStack GetConditionInfoItem(Condition condition, boolean addDescription) {
        ItemStack itemStack = MiscUtils.CreateItem(condition.getIcon(), ChatColor.GREEN + condition.getName());
        if (addDescription) {
            for (String loreLine : condition.getDescription()) {
                MiscUtils.AddLore(itemStack, ChatColor.GRAY + loreLine);
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
}
