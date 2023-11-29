package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;

public class ToggleLootConditionEnabled implements Action {
    private LootCondition lootCondition;

    public ToggleLootConditionEnabled(LootCondition lootCondition) {
        this.lootCondition = lootCondition;
    }

    @Override
    public void run() {
        lootCondition.toggleEnabled();
    }
}
