package com.gmail.cubitverde.CustomFishingRevamped.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.players.PlayersConditionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersCondition implements Condition {
    private Material icon;
    private String name;
    private List<String> description;

    private int minPlayers;
    private int maxPlayers;

    public PlayersCondition() {
        icon = Material.PLAYER_HEAD;
        name = "Online players";
        description = new ArrayList<>();
        description.add("Select a minimum and maximum");
        description.add("amount of online players.");

        minPlayers = 1;
        maxPlayers = 10;
    }

    @Override
    public boolean isMet(Player player, FishHook fishHook) {
        int onlinePlayers = CustomFishingRevamped.plugin.getServer().getOnlinePlayers().size();

        return minPlayers <= onlinePlayers && onlinePlayers <= maxPlayers;
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
        summary.add(ChatColor.DARK_GREEN + "Minimum: " + ChatColor.WHITE + minPlayers);
        summary.add(ChatColor.DARK_GREEN + "Maximum: " + ChatColor.WHITE + maxPlayers);
        return summary;
    }

    @Override
    public Menu getSettingsMenu(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        return new PlayersConditionSettings(player, bucket, lootCondition);
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
