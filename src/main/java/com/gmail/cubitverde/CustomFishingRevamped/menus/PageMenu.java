package com.gmail.cubitverde.CustomFishingRevamped.menus;

import org.bukkit.inventory.Inventory;

public interface PageMenu extends Menu {
    Inventory getMenu(int page);
}
