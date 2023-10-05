package com.gmail.cubitverde.CustomFishingRevamped.folders;

import org.bukkit.Material;

import java.util.LinkedList;

public interface Folder<T> {
    void setId(int id);
    int getId();
    void setName(String name);
    String getName();
    void setMaterial(Material material);
    Material getMaterial();
    void setItems(LinkedList<T> items);
    LinkedList<T> getItems();
}
