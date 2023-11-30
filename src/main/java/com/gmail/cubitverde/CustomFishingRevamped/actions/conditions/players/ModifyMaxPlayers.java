package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;

public class ModifyMaxPlayers implements Action {
    private PlayersCondition playersCondition;
    private int modifier;

    public ModifyMaxPlayers(PlayersCondition playersCondition, int modifier) {
        this.playersCondition = playersCondition;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        int newMax = playersCondition.getMaxPlayers() + modifier;
        playersCondition.setMaxPlayers(Math.max(newMax, playersCondition.getMinPlayers()));
    }
}
