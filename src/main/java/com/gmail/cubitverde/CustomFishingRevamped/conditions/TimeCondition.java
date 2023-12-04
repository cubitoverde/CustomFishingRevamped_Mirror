package com.gmail.cubitverde.CustomFishingRevamped.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.time.TimeConditionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TimeCondition implements Condition {
    private Material icon;
    private String name;
    private List<String> description;

    private int minTime;
    private int maxTime;

    public TimeCondition() {
        icon = Material.CLOCK;
        name = "In-game time";
        description = new ArrayList<>();
        description.add("Select an in-game timeframe.");

        minTime = 0;
        maxTime = 12000;
    }

    @Override
    public boolean isMet(Player player, FishHook fishHook) {
        long time = player.getWorld().getTime();

        return minTime <= time && time <= maxTime;
    }

    @Override
    public Material getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public List<String> getSummary() {
        List<String> summary = new ArrayList<>();
        summary.add(ChatColor.DARK_GREEN + "Start: " + ChatColor.WHITE + MiscUtils.ConvertTicksToTimeQuarters(minTime));
        summary.add(ChatColor.DARK_GREEN + "End: " + ChatColor.WHITE + MiscUtils.ConvertTicksToTimeQuarters(maxTime));
        return summary;
    }

    @Override
    public Menu getSettingsMenu(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        return new TimeConditionSettings(player, bucket, lootCondition);
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }
}
