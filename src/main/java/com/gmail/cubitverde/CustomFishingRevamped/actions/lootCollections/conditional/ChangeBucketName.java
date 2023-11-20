package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChangeBucketName implements SpeakerAction {
    private Player player;
    private ConditionalBucket bucket;
    private Menu menu;

    public ChangeBucketName(Player player, ConditionalBucket bucket, Menu menu) {
        this.player = player;
        this.bucket = bucket;
        this.menu = menu;
    }

    @Override
    public void run() {
        CustomFishingRevamped.speakers.put(player.getUniqueId(), new Speaker(player, menu, this));
        player.closeInventory();
        player.sendMessage(ChatColor.DARK_GREEN + "Enter in chat the new " + ChatColor.GREEN + "bucket name" + ChatColor.DARK_GREEN + ".");
    }

    @Override
    public void run(String message) {
        bucket.setName(message);
        player.sendMessage(ChatColor.DARK_GREEN + "Bucket name changed to: " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + ".");
    }
}
