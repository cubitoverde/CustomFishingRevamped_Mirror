package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeGlobalLootCollectionWeight implements SpeakerAction {
    private Player player;
    private LootCollection lootCollection;
    private Menu menu;

    public ChangeGlobalLootCollectionWeight(Player player, LootCollection lootCollection, Menu menu) {
        this.player = player;
        this.lootCollection = lootCollection;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "collection weight" + ChatColor.DARK_GREEN + ".");
        player.sendMessage(ChatColor.DARK_GREEN + "It must be a " + ChatColor.GREEN + "positive integer" + ChatColor.DARK_GREEN + ".");
    }

    @Override
    public void run(String message) {
        try {
            int newWeight = Integer.parseInt(message);
            if (newWeight < 0) {
                player.sendMessage(ChatColor.DARK_RED + "Error: Weight " + ChatColor.RED + message + ChatColor.DARK_RED + " is not a positive integer.");
            } else {
                lootCollection.setWeight(newWeight);
                player.sendMessage(ChatColor.DARK_GREEN + "Collection weight changed to: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "Error: Weight " + ChatColor.RED + message + ChatColor.DARK_RED + " is not a positive integer.");
        }
    }
}
