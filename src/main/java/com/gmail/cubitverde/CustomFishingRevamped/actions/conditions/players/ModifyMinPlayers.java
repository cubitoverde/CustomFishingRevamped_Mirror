package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;

public class ModifyMinPlayers implements Action {
    private PlayersCondition playersCondition;
    private int modifier;

    public ModifyMinPlayers(PlayersCondition playersCondition, int modifier) {
        this.playersCondition = playersCondition;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        int newMin = Math.max(playersCondition.getMinPlayers() + modifier, 0);
        playersCondition.setMinPlayers(Math.min(newMin, playersCondition.getMaxPlayers()));
    }
}
