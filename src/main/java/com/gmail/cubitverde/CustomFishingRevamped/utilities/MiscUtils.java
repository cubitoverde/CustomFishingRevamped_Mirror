package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

    public static LinkedList<String> GetColors() {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("BLACK");
        colors.add("BLUE");
        colors.add("BROWN");
        colors.add("CYAN");
        colors.add("GRAY");
        colors.add("GREEN");
        colors.add("LIGHT_BLUE");
        colors.add("LIGHT_GRAY");
        colors.add("LIME");
        colors.add("MAGENTA");
        colors.add("ORANGE");
        colors.add("PINK");
        colors.add("PURPLE");
        colors.add("RED");
        colors.add("WHITE");
        colors.add("YELLOW");
        return colors;
    }

    public static String GetNextColor(String color) {
        LinkedList<String> colors = GetColors();

        if (colors.contains(color)) {
            int i = colors.indexOf(color) + 1;
            return i >= colors.size() ? colors.get(0) : colors.get(i);
        }

        return null;
    }

    public static LinkedList<FireworkEffect.Type> GetShapes() {
        LinkedList<FireworkEffect.Type> types = new LinkedList<>();
        types.add(FireworkEffect.Type.BURST);
        types.add(FireworkEffect.Type.BALL_LARGE);
        types.add(FireworkEffect.Type.BALL);
        types.add(FireworkEffect.Type.STAR);
        types.add(FireworkEffect.Type.CREEPER);
        return types;
    }

    public static FireworkEffect.Type GetNextShape(FireworkEffect.Type type) {
        LinkedList<FireworkEffect.Type> types = GetShapes();

        if (types.contains(type)) {
            int i = types.indexOf(type) + 1;
            return i >= types.size() ? types.get(0) : types.get(i);
        }

        return null;
    }

    public static Material GetBooleanConcrete(boolean bool) {
        return bool ? Material.LIME_CONCRETE : Material.RED_CONCRETE;
    }
}
