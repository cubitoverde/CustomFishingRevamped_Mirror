package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.time;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.TimeCondition;

public class ModifyMinTime implements Action {
    private TimeCondition timeCondition;
    private int modifier;

    public ModifyMinTime(TimeCondition timeCondition, int modifier) {
        this.timeCondition = timeCondition;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        int newMin = (timeCondition.getMinTime() + modifier) % 24000;
        timeCondition.setMinTime(newMin);
    }
}
