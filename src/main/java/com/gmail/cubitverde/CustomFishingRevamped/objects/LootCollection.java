package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;

public class LootCollection {
    private int id;

    private Collection collection;
    private int weight;

    private int luckModifier;
    private int itemDrops;

    public LootCollection(Collection collection) {
        this.id = CustomFishingRevamped.lootCollectionId++;
        this.collection = collection;
        this.weight = 10;
        this.luckModifier = 0;
        this.itemDrops = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLuckModifier() {
        return luckModifier;
    }

    public void setLuckModifier(int luckModifier) {
        this.luckModifier = luckModifier;
    }

    public int getItemDrops() {
        return itemDrops;
    }

    public void setItemDrops(int itemDrops) {
        this.itemDrops = itemDrops;
    }
}
