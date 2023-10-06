package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollectionItem;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class CollectionItems implements PageMenu {
    private Player player;
    private Collection collection;

    public CollectionItems(Player player, Collection collection) {
        this.player = player;
        this.collection = collection;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();
        LinkedList<Drop> drops = collection.getItems();

        for (Drop drop : drops) {
            Icon icon = new Icon(PluginUtils.GetDropInfoItem(drop, collection));
            // icon.addLAction(new OpenMenu(player, -));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Collection Items]", 6*9,
                new LootCollections(player), page, new NewCollectionItem(collection), this);
    }
}
