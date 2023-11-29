package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;

public class ToggleLootConditionWhitelist implements Action {
    private LootCondition lootCondition;

    public ToggleLootConditionWhitelist(LootCondition lootCondition) {
        this.lootCondition = lootCondition;
    }

    @Override
    public void run() {
        lootCondition.toggleWhitelist();
    }
}
