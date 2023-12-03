package com.gmail.cubitverde.CustomFishingRevamped.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public interface Condition {
    boolean isMet();

    Material getIcon();
    String getName();
    List<String> getDescription();
    List<String> getSummary();
    Menu getSettingsMenu(Player player, ConditionalBucket bucket, LootCondition lootCondition);
}
