package com.gmail.cubitverde.CustomFishingRevamped.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.PlayersConditionSettings;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.Material;
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
        this.icon = Material.PLAYER_HEAD;
        this.name = "Online players";
        this.description = new ArrayList<>();
        description.add("Select a minimum and maximum");
        description.add("amount of online players.");

        this.minPlayers = 1;
        this.maxPlayers = 10;
    }

    @Override
    public boolean isMet() {
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
