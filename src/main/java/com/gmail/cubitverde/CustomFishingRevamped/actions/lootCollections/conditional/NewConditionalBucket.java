package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;

public class NewConditionalBucket implements Action {
    @Override
    public void run() {
        CustomFishingRevamped.conditionalBuckets.add(new ConditionalBucket());
    }
}
