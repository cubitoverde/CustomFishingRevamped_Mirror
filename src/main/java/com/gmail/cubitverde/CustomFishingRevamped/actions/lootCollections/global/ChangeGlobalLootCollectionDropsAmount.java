package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;

public class ChangeGlobalLootCollectionDropsAmount implements Action {
    private LootCollection lootCollection;
    private int modifier;

    public ChangeGlobalLootCollectionDropsAmount(LootCollection lootCollection, int modifier) {
        this.lootCollection = lootCollection;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        lootCollection.setItemDrops(Math.max(lootCollection.getItemDrops() + modifier, 0));
    }
}
