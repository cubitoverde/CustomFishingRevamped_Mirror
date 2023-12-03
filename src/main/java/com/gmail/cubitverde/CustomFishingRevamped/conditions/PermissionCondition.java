package com.gmail.cubitverde.CustomFishingRevamped.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.permission.PermissionConditionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.players.PlayersConditionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PermissionCondition implements Condition {
    private Material icon;
    private String name;
    private List<String> description;

    private String permission;

    public PermissionCondition() {
        icon = Material.OAK_SIGN;
        name = "Permission";
        description = new ArrayList<>();
        description.add("Choose a permission to check.");
        description.add("in the player that is fishing.");

        permission = "fishing.bonusloot";
    }

    @Override
    public boolean isMet(Player player, FishHook fishHook) {
        return player.hasPermission(permission);
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
        summary.add(ChatColor.DARK_GREEN + "Permission: " + ChatColor.WHITE + permission);
        return summary;
    }

    @Override
    public Menu getSettingsMenu(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        return new PermissionConditionSettings(player, bucket, lootCondition);
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
