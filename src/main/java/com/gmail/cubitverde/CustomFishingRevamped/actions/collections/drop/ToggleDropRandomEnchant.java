package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;

public class ToggleDropRandomEnchant implements Action {
    private Drop drop;

    public ToggleDropRandomEnchant(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        drop.toggleRandomEnchant();
    }
}
