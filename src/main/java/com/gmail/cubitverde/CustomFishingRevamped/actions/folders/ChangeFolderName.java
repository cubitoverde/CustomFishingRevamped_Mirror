package com.gmail.cubitverde.CustomFishingRevamped.actions.folders;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.folders.Folder;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeFolderName <T> implements SpeakerAction {
    private Folder<T> folder;
    private Player player;
    private Menu menu;

    public ChangeFolderName(Player player, Folder<T> folder, Menu menu) {
        this.folder = folder;
        this.player = player;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter the " + ChatColor.GREEN + "new folder name " + ChatColor.DARK_GREEN + "in chat.");
    }

    @Override
    public void run(String message) {
        folder.setName(message);
        player.sendMessage(ChatColor.DARK_GREEN + "Folder name has been changed to " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
    }
}
