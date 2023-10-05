package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class Speaker {
    private Player player;
    private Menu menu;
    private LinkedList<SpeakerAction> actions;

    public Speaker(Player player, Menu menu, SpeakerAction action) {
        this.player = player;
        this.menu = menu;
        this.actions = new LinkedList<>();
        actions.add(action);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void addAction(SpeakerAction action) {
        actions.add(action);
    }

    public LinkedList<SpeakerAction> getActions() {
        return actions;
    }

    public void setActions(LinkedList<SpeakerAction> actions) {
        this.actions = actions;
    }
}
