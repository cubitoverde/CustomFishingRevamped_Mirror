package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeDropWeight implements SpeakerAction {
    private Player player;
    private Drop drop;
    private Menu menu;

    public ChangeDropWeight(Player player, Drop drop, Menu menu) {
        this.player = player;
        this.drop = drop;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "drop weight" + ChatColor.DARK_GREEN + ".");
        player.sendMessage(ChatColor.DARK_GREEN + "It must be a " + ChatColor.GREEN + "positive integer" + ChatColor.DARK_GREEN + ".");
    }

    @Override
    public void run(String message) {
        try {
            int newWeight = Integer.parseInt(message);
            if (newWeight < 0) {
                player.sendMessage(ChatColor.DARK_RED + "Error: Weight " + ChatColor.RED + message + ChatColor.DARK_RED + " is not a positive integer.");
            } else {
                drop.setWeight(newWeight);
                player.sendMessage(ChatColor.DARK_GREEN + "Drop weight changed to: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "Error: Weight " + ChatColor.RED + message + ChatColor.DARK_RED + " is not a positive integer.");
        }
    }
}
