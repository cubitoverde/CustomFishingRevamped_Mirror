package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import org.bukkit.inventory.ItemStack;

public class ChangeDropItem implements Action {
    private Drop drop;
    private ItemStack item;

    public ChangeDropItem(Drop drop, ItemStack item) {
        this.drop = drop;
        this.item = item;
    }

    @Override
    public void run() {
        drop.setItem(item);
    }
}
