package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.ChangePage;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Holder;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class GuiUtils {
    public static List<Integer> InventoryFrame(int size) {
        List<Integer> frame = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < 9 || size - i < 9 || i % 9 == 0 || i % 9 == 8) {
                frame.add(i);
            }
        }
        return frame;
    }

    public static LinkedList<Integer> InventoryInside(int size) {
        LinkedList<Integer> inside = new LinkedList<>();
        List<Integer> frame = InventoryFrame(size);
        for (int i = 0; i < size; i++) {
            if (!frame.contains(i)) {
                inside.add(i);
            }
        }
        return inside;
    }

    public static void AddGreenFrame(Inventory inventory) {
        int size = inventory.getSize();

        for (int i = 0; i < size; i++) {
            inventory.setItem(i, MiscUtils.CreateItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " "));
        }

        for (int i : InventoryFrame(size)) {
            inventory.setItem(i, MiscUtils.CreateItem(Material.LIME_STAINED_GLASS_PANE, " "));
        }

        {
            inventory.setItem(4, MiscUtils.CreateItem(Material.WHITE_STAINED_GLASS_PANE,
                    ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "Custom Fishing Revamped" + ChatColor.DARK_GREEN + "]",
                    ChatColor.DARK_GREEN + "Created by: " + ChatColor.GREEN + "cubitoverde"));
        }
    }

    public static Inventory BuildInventory(Player player, Map<Integer, Icon> icons, String title, int size, Menu backMenu) {
        Holder holder = new Holder(player, icons, title, size);
        Inventory inventory = Bukkit.createInventory(holder, size, title);
        AddGreenFrame(inventory);

        if (backMenu != null) {
            AddBackItem(player, backMenu, icons, size);
        }

        for (int i : icons.keySet()) {
            inventory.setItem(i, icons.get(i).getItem().clone());
        }

        return inventory;
    }

    public static Inventory BuildInventory(Player player, LinkedList<Icon> icons, String title, int size, Menu backMenu,
                                           int page, Action newItemAction, boolean refreshWhenNewItem, PageMenu thisMenu) {
        LinkedList<Integer> inventoryInside = InventoryInside(size);
        int insideSize = inventoryInside.size();
        int listSize = icons.size();
        Map<Integer, Icon> iconsMap = new HashMap<>();

        boolean reachedEnd = false;
        int startSlot = (page - 1) * insideSize;
        for (int i = 0; i < insideSize; i++) {
            if (startSlot + i >= listSize) {
                if (newItemAction != null) {
                    Icon icon = new Icon(MiscUtils.CreateItem(Material.LIME_DYE, ChatColor.GREEN + "New"));
                    icon.addAction(newItemAction);
                    if (refreshWhenNewItem) {
                        icon.addAction(new OpenMenu(player, thisMenu, page));
                    }
                    iconsMap.put(inventoryInside.get(i), icon);
                }
                break;
            }
            iconsMap.put(inventoryInside.get(i), icons.get(startSlot + i));
            if (i == insideSize - 1) {
                reachedEnd = true;
            }
        }

        Icon pageIcon = new Icon(MiscUtils.CreateItem(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.DARK_GREEN + "Current page: " + ChatColor.GREEN + page));
        iconsMap.put(size - 2, pageIcon);

        if (page > 1) {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Previous page"));
            icon.addAction(new ChangePage(player, thisMenu, page - 1));
            iconsMap.put(size - 3, icon);
        }

        if (newItemAction != null) {
            if (reachedEnd) {
                Icon icon = new Icon(MiscUtils.CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Next page"));
                icon.addAction(new ChangePage(player, thisMenu, page + 1));
                iconsMap.put(size - 1, icon);
            }
        } else {
            if (reachedEnd && (startSlot + insideSize) < listSize) {
                Icon icon = new Icon(MiscUtils.CreateItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "Next page"));
                icon.addAction(new ChangePage(player, thisMenu, page + 1));
                iconsMap.put(size - 1, icon);
            }
        }

        if (backMenu != null) {
            AddBackItem(player, backMenu, iconsMap, size);
        }

        return BuildInventory(player, iconsMap, title, size, backMenu);
    }

    public static Inventory BuildInventory(Player player, LinkedList<Icon> icons, String title, int size, Menu backMenu,
                                           int page, Action newItemAction, PageMenu thisMenu) {
        return BuildInventory(player, icons, title, size, backMenu, page, newItemAction, true, thisMenu);
    }

    public static void AddBackItem(Player player, Menu menu, Map<Integer, Icon> icons, int size) {
        Icon icon = new Icon(MiscUtils.CreateItem(Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "Go back"));
        if (menu instanceof PageMenu) {
            icon.addAction(new OpenMenu(player, menu, 1));
        } else {
            icon.addAction(new OpenMenu(player, menu));
        }
        icons.put(size - 9, icon);
    }
}
