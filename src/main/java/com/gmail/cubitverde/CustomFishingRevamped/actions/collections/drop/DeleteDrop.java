package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;

public class DeleteDrop implements Action {
    private Collection collection;
    private Drop drop;

    public DeleteDrop(Collection collection, Drop drop) {
        this.collection = collection;
        this.drop = drop;
    }

    @Override
    public void run() {
        collection.getItems().remove(drop);
    }
}
