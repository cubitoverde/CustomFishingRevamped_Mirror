package com.gmail.cubitverde.CustomFishingRevamped.actions.menus;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import org.bukkit.entity.Player;

public class OpenMenu implements Action {
    private Player player;
    private Menu menu;
    private int page;

    public OpenMenu(Player player, Menu menu) {
        this.player = player;
        this.menu = menu;
        this.page = 1;
    }

    public OpenMenu(Player player, Menu menu, int page) {
        this.player = player;
        this.menu = menu;
        this.page = page;
    }

    @Override
    public void run() {
        if (menu instanceof PageMenu) {
            player.openInventory(((PageMenu) menu).getMenu(page));
        } else {
            player.openInventory(menu.getMenu());
        }
    }
}
