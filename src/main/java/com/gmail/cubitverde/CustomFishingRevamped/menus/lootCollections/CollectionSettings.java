package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings.*;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class CollectionSettings implements Menu {
    private Player player;
    private Collection collection;

    public CollectionSettings(Player player, Collection collection) {
        this.player = player;
        this.collection = collection;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName()));
            icons.put(10, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.NAME_TAG, ChatColor.GREEN + "Change name"));
            icon.addAction(new ChangeCollectionName(player, collection, this));
            icons.put(15, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.ITEM_FRAME, ChatColor.GREEN + "Change icon"));
            icon.addAction(new OpenMenu(player, new CollectionChangingIcon(player, collection)));
            icons.put(16, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.FIREWORK_STAR, ChatColor.GREEN + "Effect shape",
                    ChatColor.DARK_GREEN + "Current shape: " + ChatColor.GRAY + collection.getShape().toString()));
            icon.addAction(new ChangeCollectionEffectShape(collection));
            icon.addAction(new OpenMenu(player,this));
            icons.put(23, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.getMaterial(collection.getColor() + "_CONCRETE_POWDER"), ChatColor.GREEN + "Effect color",
                    ChatColor.DARK_GREEN + "Current color: " + ChatColor.GRAY + collection.getColor()));
            icon.addAction(new ChangeCollectionEffectColor(collection));
            icon.addAction(new OpenMenu(player, this));
            icons.put(24, icon);
        } {
            Icon icon;
            if (collection.getEffect()) {
                icon = new Icon(MiscUtils.CreateItem(Material.GREEN_CONCRETE, ChatColor.GREEN + "Toggle effect",
                        ChatColor.DARK_GREEN + "Effect currently ON",
                        ChatColor.GRAY + "Particles will appear when fishing an item"));
            } else {
                icon = new Icon(MiscUtils.CreateItem(Material.RED_CONCRETE, ChatColor.RED + "Toggle effect",
                        ChatColor.DARK_RED + "Effect currently OFF",
                        ChatColor.GRAY + "No particles will appear when fishing an item"));
            }
            icon.addAction(new ToggleCollectionEffect(collection));
            icon.addAction(new OpenMenu(player, this));
            icons.put(25, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BARRIER, ChatColor.RED + "Delete collection",
                    ChatColor.DARK_RED + "Shift click to delete this collection"));
            icon.addShiftAction(new DeleteCollection(collection));
            icon.addShiftAction(new OpenMenu(player, new CollectionsList(player)));
            icons.put(19, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Collection Settings]", 4*9, new CollectionsList(player));
    }
}
