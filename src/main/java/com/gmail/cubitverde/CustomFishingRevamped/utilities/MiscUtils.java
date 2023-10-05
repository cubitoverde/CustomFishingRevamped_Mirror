package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiscUtils {
    public static ItemStack CreateItem(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack CreateItem(Material material, String name, String... lore) {
        ItemStack itemStack = CreateItem(material, name);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> loreList = new ArrayList<>();
        Collections.addAll(loreList, lore);
        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
