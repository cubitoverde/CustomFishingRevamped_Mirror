package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;

public class Icon {
    private ItemStack item;
    private LinkedList<Action> LActions = new LinkedList<>();
    private LinkedList<Action> RActions = new LinkedList<>();
    private LinkedList<Action> ShiftActions = new LinkedList<>();

    public Icon(ItemStack item) {
        this.item = item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
    public ItemStack getItem() {
        return item;
    }

    public void addLAction(Action action) {
        LActions.add(action);
    }
    public void addRAction(Action action) {
        RActions.add(action);
    }
    public void addAction(Action action) {
        LActions.add(action);
        RActions.add(action);
    }

    public void setLActions(LinkedList<Action> actions) {
        this.LActions = actions;
    }
    public LinkedList<Action> getLActions() {
        return LActions;
    }

    public void setRActions(LinkedList<Action> actions) {
        this.RActions = actions;
    }
    public LinkedList<Action> getRActions() {
        return RActions;
    }

    public void setActions(LinkedList<Action> actions) {
        this.LActions = actions;
        this.RActions = actions;
    }

    public void addShiftAction(Action action) {
        ShiftActions.add(action);
    }

    public void setShiftActions(LinkedList<Action> actions) {
        this.ShiftActions = actions;
    }
    public LinkedList<Action> getShiftActions() {
        return ShiftActions;
    }
}
