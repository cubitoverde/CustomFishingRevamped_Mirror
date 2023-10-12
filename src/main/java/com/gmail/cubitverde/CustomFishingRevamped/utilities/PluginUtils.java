package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
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

    public static int GetCollectionTotalWeight(Collection collection) {
        int total = 0;
        for (Drop tempDrop : collection.getItems()) {
            total += tempDrop.getWeight();
        }

        return total;
    }

    public static double GetDropChanceInCollection(Drop drop, Collection collection) {
        int weight = drop.getWeight();
        int total = GetCollectionTotalWeight(collection);

        return ((double) weight) / ((double) total);
    }

    public static ItemStack GetCollectionDropInfoItem(Drop drop, Collection collection) {
        ItemStack item = MiscUtils.CreateItem(Material.PAPER, ChatColor.GREEN + "Information");
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Drop weight: " + ChatColor.GRAY + drop.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Total collection weight: " + ChatColor.GRAY + GetCollectionTotalWeight(collection));

        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInCollection(drop, collection)));

        lore.add(ChatColor.DARK_GREEN + "Commands: " + ChatColor.GRAY + drop.getCommands().size());

        lore.add(ChatColor.DARK_GREEN + "Has durability: " + ChatColor.GRAY + ItemHasDurability(drop.getItem()));
        lore.add(ChatColor.DARK_GREEN + "Is enchantable: " + ChatColor.GRAY + ItemIsEnchantable(drop.getItem()));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static boolean ItemHasDurability(ItemStack item) {
        return item.getType().getMaxDurability() > 1;
    }

    public static boolean ItemIsEnchantable(ItemStack item) {
        return Enchantment.DURABILITY.canEnchantItem(item);
    }
}
