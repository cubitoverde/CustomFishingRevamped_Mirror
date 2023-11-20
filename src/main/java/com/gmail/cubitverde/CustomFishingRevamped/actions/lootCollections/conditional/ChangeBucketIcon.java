package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import org.bukkit.Material;

public class ChangeBucketIcon implements Action {
    private ConditionalBucket bucket;
    private Material icon;

    public ChangeBucketIcon(ConditionalBucket bucket, Material icon) {
        this.bucket = bucket;
        this.icon = icon;
    }

    @Override
    public void run() {
        bucket.setIcon(icon);
    }
}
