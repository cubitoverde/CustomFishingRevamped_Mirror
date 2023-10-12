package com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.global;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;

public class RemoveGlobalLootCollection implements Action {
    private LootCollection lootCollection;

    public RemoveGlobalLootCollection(LootCollection lootCollection) {
        this.lootCollection = lootCollection;
    }

    @Override
    public void run() {
        CustomFishingRevamped.globalLootCollections.remove(lootCollection);
    }
}
