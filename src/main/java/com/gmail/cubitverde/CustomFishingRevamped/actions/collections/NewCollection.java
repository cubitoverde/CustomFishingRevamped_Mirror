package com.gmail.cubitverde.CustomFishingRevamped.actions.collections;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import org.bukkit.entity.Player;

public class NewCollection implements Action {
    private Player player;

    public NewCollection(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        CustomFishingRevamped.collections.add(new Collection());
    }
}
