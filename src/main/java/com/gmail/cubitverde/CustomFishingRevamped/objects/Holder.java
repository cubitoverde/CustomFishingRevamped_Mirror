package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.LinkedList;
import java.util.Map;

public class Holder implements InventoryHolder {
    private Player player;
    private Map<Integer, Icon> icons;
    private String title;
    private int size;

    public Holder(Player player, Map<Integer, Icon> icons, String title, int size) {
        this.player = player;
        this.icons = icons;
        this.title = title;
        this.size = size;
    }

    @Override
    public Inventory getInventory() {
        return player.getInventory();
    }

    public void trigger(int slot, boolean isLeftClick, boolean isRightClick, boolean isShiftClick) {
        if (icons.containsKey(slot)) {
            if (isLeftClick) {
                LinkedList<Action> LActions = icons.get(slot).getLActions();
                for (Action action : LActions) {
                    action.run();
                }
            }
            if (isRightClick) {
                LinkedList<Action> RActions = icons.get(slot).getRActions();
                for (Action action : RActions) {
                    action.run();
                }
            }
            if (isShiftClick) {
                LinkedList<Action> ShiftActions = icons.get(slot).getShiftActions();
                for (Action action : ShiftActions) {
                    action.run();
                }
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<Integer, Icon> getIcons() {
        return icons;
    }

    public void setIcons(Map<Integer, Icon> icons) {
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
