package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AddBucketCollection implements Action {
    private Player player;
    private ConditionalBucket bucket;
    private Collection collection;

    public AddBucketCollection(Player player, ConditionalBucket bucket, Collection collection) {
        this.player = player;
        this.bucket = bucket;
        this.collection = collection;
    }

    @Override
    public void run() {
        if (PluginUtils.CheckIfCollectionInListLootCollections(collection, bucket.getCollections())) {
            player.sendMessage(ChatColor.DARK_RED + "That collection is " + ChatColor.RED + "already part " + ChatColor.DARK_RED + "of the bucket.");
        } else {
            bucket.getCollections().add(new LootCollection(collection));
        }
    }
}
