package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

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

    public static ItemStack CreateItem(Material material, String name, LinkedList<String> lore) {
        ItemStack itemStack = CreateItem(material, name);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(lore);
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

    public static Color GetColorFromString(String colorString) {
        String string = colorString.toLowerCase();
        switch (string) {
            case "black": {
                return Color.fromBGR(33, 29, 29);
            } case "blue": {
                return Color.fromBGR(169, 68, 60);
            } case "brown": {
                return Color.fromBGR(50, 84, 130);
            } case "cyan": {
                return Color.fromBGR(157, 156, 22);
            } case "gray": {
                return Color.fromBGR(82, 79, 71);
            } case "green": {
                return Color.fromBGR(21, 124, 93);
            } case "light_blue": {
                return Color.fromBGR(218, 179, 58);
            } case "light_gray": {
                return Color.fromBGR(151, 157, 156);
            } case "lime": {
                return Color.fromBGR(31, 199, 128);
            } case "magenta": {
                return Color.fromBGR(189, 79, 198);
            } case "orange": {
                return Color.fromBGR(29, 128, 249);
            } case "pink": {
                return Color.fromBGR(170, 140, 243);
            } case "purple": {
                return Color.fromBGR(183, 50, 137);
            } case "red": {
                return Color.fromBGR(38, 46, 176);
            } case "white": {
                return Color.fromBGR(255, 255, 249);
            } case "yellow": {
                return Color.fromBGR(61, 216, 255);
            }
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


}
