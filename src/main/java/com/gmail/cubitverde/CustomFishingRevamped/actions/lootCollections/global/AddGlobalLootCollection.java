package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AddGlobalLootCollection implements Action {
    private Player player;
    private Collection collection;

    public AddGlobalLootCollection(Player player, Collection collection) {
        this.player = player;
        this.collection = collection;
    }

    @Override
    public void run() {
        if (PluginUtils.CheckIfCollectionInList(collection, PluginUtils.GetGlobalCollections())) {
            player.sendMessage(ChatColor.DARK_RED + "That collection is " + ChatColor.RED + "already part " + ChatColor.DARK_RED + "of the global loot.");
        } else {
            CustomFishingRevamped.globalLootCollections.add(new LootCollection(collection));
        }
    }
}
