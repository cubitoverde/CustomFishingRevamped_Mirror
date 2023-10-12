package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class NewDropCommand implements SpeakerAction {
    private Player player;
    private Drop drop;
    private Menu menu;

    public NewDropCommand(Player player, Drop drop, Menu menu) {
        this.player = player;
        this.drop = drop;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "command" + ChatColor.DARK_GREEN + ".");
        player.sendMessage(ChatColor.DARK_GREEN + "Type the command " + ChatColor.GREEN + "without " + ChatColor.DARK_GREEN + "the initial slash ( / ).");
    }

    @Override
    public void run(String message) {
        drop.getCommands().add(message);
        player.sendMessage(ChatColor.DARK_GREEN + "Commands added: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
    }
}
