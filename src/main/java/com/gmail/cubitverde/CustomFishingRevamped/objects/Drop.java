package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;

public class Drop {
    private int id;

    private ItemStack item;
    private int weight;

    private boolean randomEnchant;
    private boolean randomDurability;

    private LinkedList<String> commands;

    public Drop() {
        this.id = CustomFishingRevamped.dropId++;
        this.item = MiscUtils.CreateItem(Material.COD, ChatColor.GREEN + "New item");
        this.weight = 10;
        this.randomEnchant = false;
        this.randomDurability = false;
        this.commands = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getRandomEnchant() {
        return randomEnchant;
    }

    public void setRandomEnchant(boolean randomEnchant) {
        this.randomEnchant = randomEnchant;
    }

    public void toggleRandomEnchant() {
        this.randomEnchant = !this.randomEnchant;
    }

    public boolean getRandomDurability() {
        return randomDurability;
    }

    public void setRandomDurability(boolean randomDurability) {
        this.randomDurability = randomDurability;
    }

    public void toggleRandomDurability() {
        this.randomDurability = !this.randomDurability;
    }

    public LinkedList<String> getCommands() {
        return commands;
    }

    public void setCommands(LinkedList<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }
}
