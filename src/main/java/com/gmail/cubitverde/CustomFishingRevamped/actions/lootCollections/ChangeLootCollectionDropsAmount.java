package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;

public class ChangeLootCollectionDropsAmount implements Action {
    private LootCollection lootCollection;
    private int modifier;

    public ChangeLootCollectionDropsAmount(LootCollection lootCollection, int modifier) {
        this.lootCollection = lootCollection;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        lootCollection.setItemDrops(Math.max(lootCollection.getItemDrops() + modifier, 0));
    }
}
