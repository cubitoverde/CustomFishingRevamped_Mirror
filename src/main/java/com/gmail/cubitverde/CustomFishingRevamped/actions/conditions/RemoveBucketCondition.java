package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;

public class RemoveBucketCondition implements Action {
    private ConditionalBucket bucket;
    private LootCondition lootCondition;

    public RemoveBucketCondition(ConditionalBucket bucket, LootCondition lootCondition) {
        this.bucket = bucket;
        this.lootCondition = lootCondition;
    }

    @Override
    public void run() {
        bucket.getConditions().remove(lootCondition);
    }
}
