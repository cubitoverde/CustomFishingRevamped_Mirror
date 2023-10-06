package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;

public class DeleteCollection implements Action {
    private Collection collection;

    public DeleteCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        CustomFishingRevamped.collections.remove(collection);
    }
}
