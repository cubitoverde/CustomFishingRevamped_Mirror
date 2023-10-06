package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class PluginUtils {
    public static ItemStack GetDropInfoItem(Drop drop, Collection collection) {
        ItemStack item = drop.getItem().clone();
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Weight: " + ChatColor.GRAY + drop.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInCollection(drop, collection)));

        lore.add(ChatColor.DARK_GREEN + "Commands: " + ChatColor.GRAY + drop.getCommands().size());

        if (itemMeta.getLore() != null) {
            lore.add(" ");
            lore.addAll(itemMeta.getLore());
        }

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static double GetDropChanceInCollection(Drop drop, Collection collection) {
        int weight = drop.getWeight();
        LinkedList<Drop> drops = collection.getItems();

        int total = 0;
        for (Drop tempDrop : drops) {
            total += tempDrop.getWeight();
        }

        return ((double) weight) / ((double) total);
    }
}
