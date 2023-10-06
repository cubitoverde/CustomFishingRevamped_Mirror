package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeCollectionName implements SpeakerAction {
    Player player;
    Collection collection;
    Menu menu;

    public ChangeCollectionName(Player player, Collection collection, Menu menu) {
        this.player = player;
        this.collection = collection;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "collection name" + ChatColor.DARK_GREEN + ".");
    }

    @Override
    public void run(String message) {
        collection.setName(message);
        player.sendMessage(ChatColor.DARK_GREEN + "Collection name changed to: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
    }
}
