package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;

import java.util.LinkedList;

public class Collection {
    private int id;

    private String name;
    private Material icon;

    private LinkedList<Drop> items;

    private String color;
    private FireworkEffect.Type shape;
    private boolean effect;

    public Collection() {
        this.id = CustomFishingRevamped.collectionId++;
        this.name = ChatColor.GREEN + "New collection";
        this.icon = Material.CHEST;
        this.items = new LinkedList<>();
        this.color = "LIME";
        this.shape = FireworkEffect.Type.BURST;
        this.effect = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getIcon() {
        return icon;
    }

    public void setIcon(Material icon) {
        this.icon = icon;
    }

    public LinkedList<Drop> getItems() {
        return items;
    }

    public void setItems(LinkedList<Drop> items) {
        this.items = items;
    }

    public void addItem(Drop item) {
        this.items.add(item);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void rotateColor() {
        this.color = MiscUtils.GetNextColor(this.color);
    }

    public FireworkEffect.Type getShape() {
        return shape;
    }

    public void setShape(FireworkEffect.Type shape) {
        this.shape = shape;
    }

    public void rotateShape() {
        this.shape = MiscUtils.GetNextShape(this.shape);
    }

    public boolean getEffect() {
        return effect;
    }

    public void setEffect(boolean effect) {
        this.effect = effect;
    }

    public void toggleEffect() {
        this.effect = !this.effect;
    }
}
