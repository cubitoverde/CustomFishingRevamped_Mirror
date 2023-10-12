package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop.ChangeDropItem;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class DropChangingItem implements Menu {
    private Player player;
    private Collection collection;
    private Drop drop;

    public DropChangingItem(Player player, Collection collection, Drop drop) {
        this.player = player;
        this.collection = collection;
        this.drop = drop;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        for (int i = 0; i < 36; i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null) {
                Icon icon = new Icon(item);
                icon.addAction(new ChangeDropItem(drop, item));
                icon.addAction(new OpenMenu(player, new DropSettings(player, collection, drop)));
                icons.put(i + 9, icon);
            } else {
                Icon icon = new Icon(MiscUtils.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
                icons.put(i + 9, icon);
            }
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Drop Item]", 6*9, new CollectionItems(player, collection));
    }
}
