package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop.*;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.settings.DeleteCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class DropSettings implements Menu {
    private Player player;
    private Collection collection;
    private Drop drop;

    public DropSettings(Player player, Collection collection, Drop drop) {
        this.player = player;
        this.collection = collection;
        this.drop = drop;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();

        {
            Icon icon = new Icon(drop.getItem());
            icons.put(10, icon);
        } {
            Icon icon = new Icon(PluginUtils.GetCollectionDropInfoItem(drop, collection));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.CLOCK, ChatColor.GREEN + "Change weight",
                    ChatColor.DARK_GREEN + "Current weight: " + ChatColor.GRAY + drop.getWeight()));
            icon.addAction(new ChangeDropWeight(player, drop, this));
            icons.put(14, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.ITEM_FRAME, ChatColor.GREEN + "Change item"));
            icon.addAction(new OpenMenu(player, new DropChangingItem(player, collection, drop)));
            icons.put(15, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + "Change commands",
                    ChatColor.DARK_GREEN + "Current commands: " + ChatColor.GRAY + drop.getCommands().size()));
            icon.addAction(new OpenMenu(player, new DropCommands(player, collection, drop)));
            icons.put(16, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BARRIER, ChatColor.RED + "Delete drop",
                    ChatColor.DARK_RED + "Shift click to delete this drop"));
            icon.addShiftAction(new DeleteDrop(collection, drop));
            icon.addShiftAction(new OpenMenu(player, new CollectionItems(player, collection)));
            icons.put(19, icon);
        } {
            Icon icon;
            if (drop.getRandomDurability()) {
                icon = new Icon(MiscUtils.CreateItem(Material.ANVIL, ChatColor.GREEN + "Toggle random durability",
                        ChatColor.DARK_GREEN + "Random durability currently ON",
                        ChatColor.GRAY + "The item will drop with random durability"));
            } else {
                icon = new Icon(MiscUtils.CreateItem(Material.ANVIL, ChatColor.RED + "Toggle random durability",
                        ChatColor.DARK_RED + "Random durability currently OFF",
                        ChatColor.GRAY + "The item will drop with full durability"));
            }
            icon.addAction(new ToggleDropRandomDurability(drop));
            icon.addAction(new OpenMenu(player, this));
            icons.put(24, icon);
        } {
            Icon icon;
            if (drop.getRandomEnchant()) {
                icon = new Icon(MiscUtils.CreateItem(Material.ENCHANTING_TABLE, ChatColor.GREEN + "Toggle random enchantments",
                        ChatColor.DARK_GREEN + "Random enchantments currently ON",
                        ChatColor.GRAY + "The item will drop with random enchantments"));
            } else {
                icon = new Icon(MiscUtils.CreateItem(Material.ENCHANTING_TABLE, ChatColor.RED + "Toggle random enchantments",
                        ChatColor.DARK_RED + "Random enchantments currently OFF",
                        ChatColor.GRAY + "The item will drop with no enchantments"));
            }
            icon.addAction(new ToggleDropRandomEnchant(drop));
            icon.addAction(new OpenMenu(player, this));
            icons.put(25, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Drop Settings]", 4*9, new CollectionItems(player, collection));
    }
}
