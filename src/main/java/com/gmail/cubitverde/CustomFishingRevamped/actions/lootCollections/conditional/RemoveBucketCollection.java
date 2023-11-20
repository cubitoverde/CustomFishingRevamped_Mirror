package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;

public class RemoveBucketCollection implements Action {
    private ConditionalBucket bucket;
    private LootCollection lootCollection;

    public RemoveBucketCollection(ConditionalBucket bucket, LootCollection lootCollection) {
        this.bucket = bucket;
        this.lootCollection = lootCollection;
    }

    @Override
    public void run() {
        bucket.getCollections().remove(lootCollection);
    }
}
