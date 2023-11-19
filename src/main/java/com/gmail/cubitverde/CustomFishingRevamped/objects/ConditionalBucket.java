package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.LinkedList;

public class ConditionalBucket {
    private int id;
    private String name;
    private Material icon;

    private LinkedList<LootCondition> conditions;
    private LinkedList<LootCollection> collections;

    public ConditionalBucket() {
        this.id = CustomFishingRevamped.conditionalBucketId++;
        this.name = ChatColor.GREEN + "New conditional bucket";
        this.icon = Material.BUCKET;
        this.conditions = new LinkedList<>();
        this.collections = new LinkedList<>();
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

    public LinkedList<LootCondition> getConditions() {
        return conditions;
    }

    public void setConditions(LinkedList<LootCondition> conditions) {
        this.conditions = conditions;
    }

    public void addCondition(LootCondition condition) {
        this.conditions.add(condition);
    }

    public LinkedList<LootCollection> getCollections() {
        return collections;
    }

    public void setCollections(LinkedList<LootCollection> collections) {
        this.collections = collections;
    }

    public void addCollection(LootCollection collection) {
        this.collections.add(collection);
    }
}
