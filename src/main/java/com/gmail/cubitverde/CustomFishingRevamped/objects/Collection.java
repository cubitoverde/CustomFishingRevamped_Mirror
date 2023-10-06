package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.LinkedList;

public class Collection {
    private int id;

    private String name;
    private Material icon;

    private LinkedList<Drop> items;

    public Collection() {
        this.id = CustomFishingRevamped.collectionId++;
        this.name = ChatColor.GREEN + "New collection";
        this.icon = Material.CHEST;
        this.items = new LinkedList<>();
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
}
