package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;

public class ToggleDropRandomDurability implements Action {
    private Drop drop;

    public ToggleDropRandomDurability(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        drop.toggleRandomDurability();
    }
}
