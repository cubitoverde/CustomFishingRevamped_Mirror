package com.gmail.cubitverde.CustomFishingRevamped.actions.collections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;

public class NewCollectionItem implements Action {
    private Collection collection;

    public NewCollectionItem(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        collection.addItem(new Drop());
    }
}
