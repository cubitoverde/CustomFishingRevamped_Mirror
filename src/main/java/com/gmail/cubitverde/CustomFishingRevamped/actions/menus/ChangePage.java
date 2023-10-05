package com.gmail.cubitverde.CustomFishingRevamped.actions.menus;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import org.bukkit.entity.Player;

public class ChangePage implements Action {
    private Player player;
    private PageMenu pageMenu;
    private int page;

    public ChangePage(Player player, PageMenu pageMenu, int page) {
        this.player = player;
        this.pageMenu = pageMenu;
        this.page = page;
    }

    @Override
    public void run() {
        player.openInventory(pageMenu.getMenu(page));
    }
}
