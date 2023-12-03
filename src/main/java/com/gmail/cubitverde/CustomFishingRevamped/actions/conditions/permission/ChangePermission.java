package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.permission;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PermissionCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangePermission implements SpeakerAction {
    private Player player;
    private ConditionalBucket bucket;
    private PermissionCondition condition;
    private Menu menu;

    public ChangePermission(Player player, ConditionalBucket bucket, PermissionCondition condition, Menu menu) {
        this.player = player;
        this.bucket = bucket;
        this.condition = condition;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "permission" + ChatColor.DARK_GREEN + ".");
    }

    @Override
    public void run(String message) {
        condition.setPermission(message);
        player.sendMessage(ChatColor.DARK_GREEN + "Permission changed to: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
    }
}
