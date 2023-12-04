package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.time;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.time.ModifyMaxTime;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.time.ModifyMinTime;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.TimeCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.BucketConditions;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class TimeConditionSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCondition lootCondition;

    public TimeConditionSettings(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        this.player = player;
        this.bucket = bucket;
        this.lootCondition = lootCondition;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();
        TimeCondition condition = (TimeCondition) lootCondition.getCondition();

        ConditionUtils.AddBaseConditionSettingsIcons(icons, player, lootCondition, bucket,
                19, 20, 21, this);

        {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BLUE_WOOL, ChatColor.GREEN + "Starting time",
                    ChatColor.DARK_GREEN + "Current time: " + ChatColor.WHITE + MiscUtils.ConvertTicksToTimeQuarters(condition.getMinTime()),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Add 15 minutes",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Remove 15 minutes"));
            icon.addLAction(new ModifyMinTime(condition, 250));
            icon.addRAction(new ModifyMinTime(condition, -250));
            icon.addAction(new OpenMenu(player, this));
            icons.put(13, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.RED_WOOL, ChatColor.GREEN + "Ending time",
                    ChatColor.DARK_GREEN + "Current time: " + ChatColor.WHITE + MiscUtils.ConvertTicksToTimeQuarters(condition.getMaxTime()),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Add 15 minutes",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Remove 15 minutes"));
            icon.addLAction(new ModifyMaxTime(condition, 250));
            icon.addRAction(new ModifyMaxTime(condition, -250));
            icon.addAction(new OpenMenu(player, this));
            icons.put(14, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.CLOCK, ChatColor.GREEN + "Guidelines",
                    ChatColor.DARK_GREEN + "Sunrise: " + ChatColor.GRAY + "5:00 - 6:00",
                    ChatColor.DARK_GREEN + "Day: " + ChatColor.GRAY + "6:00 - 18:00 (Noon: 12:00)",
                    ChatColor.DARK_GREEN + "Sunset: " + ChatColor.GRAY + "18:00 - 19:00",
                    ChatColor.DARK_GREEN + "Night: " + ChatColor.GRAY + "19:00 - 5:00 (Midnight: 00:00)",
                    ChatColor.DARK_GREEN + "Current time: " + ChatColor.WHITE + MiscUtils.ConvertTicksToTimeExact((int) player.getWorld().getTime()),
                    ChatColor.GRAY + "Click to update current time"));
            icon.addAction(new OpenMenu(player, this));
            icons.put(16, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Condition Settings]", 4*9, new BucketConditions(player, bucket));
    }
}
