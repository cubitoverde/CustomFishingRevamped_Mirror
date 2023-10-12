package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

    public static ItemStack GetGlobalLootCollectionItem(LootCollection lootCollection) {
        Collection collection = lootCollection.getCollection();
        ItemStack item = MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName());
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "View items");
        lore.add(ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Settings");

        lore.add(ChatColor.GRAY + " ");

        lore.addAll(GetGlobalLootModifierInfoLore(lootCollection));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static LinkedList<String> GetGlobalLootModifierInfoLore(LootCollection lootCollection) {
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Collection weight: " + ChatColor.GRAY + lootCollection.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Total global loot weight: " + ChatColor.GRAY + GetGlobalTotalWeight());

        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInGlobal(lootCollection)));

        lore.add(ChatColor.DARK_GREEN + "Luck modifier: " + ChatColor.GRAY + GetIntModifierAsString(lootCollection.getLuckModifier()));
        lore.add(ChatColor.DARK_GREEN + "Items dropped: " + ChatColor.GRAY + lootCollection.getItemDrops());

        return lore;
    }

    public static int GetGlobalTotalWeight() {
        int total = 0;
        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            total += lootCollection.getWeight();
        }
        return total;
    }

    public static double GetDropChanceInGlobal(LootCollection lootCollection) {
        int weight = lootCollection.getWeight();
        int total = GetGlobalTotalWeight();

        return ((double) weight) / ((double) total);
    }

    public static String GetIntModifierAsString(int intModifier) {
        return intModifier > 0 ? "+" + intModifier : "" + intModifier;
    }

    public static String ColorIntModifier(int intModifier) {
        String text = GetIntModifierAsString(intModifier);
        if (intModifier > 0) {
            return ChatColor.GREEN + text;
        } else if (intModifier < 0) {
            return ChatColor.RED + text;
        } else {
            return ChatColor.WHITE + text;
        }
    }

    public static boolean CheckIfCollectionInList(Collection collection, LinkedList<Collection> collections) {
        int id = collection.getId();
        for (Collection tempCollection : collections) {
            if (tempCollection.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Collection> GetGlobalCollections() {
        LinkedList<Collection> collections = new LinkedList<>();
        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            collections.add(lootCollection.getCollection());
        }
        return collections;
    }
}
