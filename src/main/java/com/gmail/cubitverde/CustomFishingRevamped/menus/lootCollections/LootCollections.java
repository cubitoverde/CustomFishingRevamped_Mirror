package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.MainMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class LootCollections implements PageMenu {
    private Player player;

    public LootCollections(Player player) {
        this.player = player;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();

        for (Collection collection : CustomFishingRevamped.collections) {
            Icon icon = new Icon(MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName(),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Items",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Settings"));
            icon.addLAction(new OpenMenu(player, new CollectionItems(player, collection)));
            icon.addRAction(new OpenMenu(player, new CollectionSettings(player, collection)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Collections List]", 6*9,
                new MainMenu(player), page, new NewCollection(player), this);
    }
}
