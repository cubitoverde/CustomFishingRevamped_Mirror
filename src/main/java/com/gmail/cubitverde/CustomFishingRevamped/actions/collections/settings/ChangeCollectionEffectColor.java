package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;

public class ChangeCollectionEffectColor implements Action {
    private Collection collection;

    public ChangeCollectionEffectColor(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        collection.rotateColor();
    }
}
