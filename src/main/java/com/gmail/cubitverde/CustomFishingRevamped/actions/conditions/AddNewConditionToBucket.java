package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;

public class AddNewConditionToBucket implements Action {
    private ConditionalBucket bucket;
    private Condition condition;

    public AddNewConditionToBucket(ConditionalBucket bucket, Condition condition) {
        this.bucket = bucket;
        this.condition = condition;
    }

    @Override
    public void run() {
        bucket.addCondition(new LootCondition(condition));
    }
}
