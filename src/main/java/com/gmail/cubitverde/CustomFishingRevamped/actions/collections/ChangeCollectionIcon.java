package com.gmail.cubitverde.CustomFishingRevamped.actions.collections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import org.bukkit.Material;

public class ChangeCollectionIcon implements Action {
    private Collection collection;
    private Material icon;

    public ChangeCollectionIcon(Collection collection, Material icon) {
        this.collection = collection;
        this.icon = icon;
    }

    @Override
    public void run() {
        collection.setIcon(icon);
    }
}
