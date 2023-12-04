package com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.time;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.TimeCondition;

public class ModifyMaxTime implements Action {
    private TimeCondition timeCondition;
    private int modifier;

    public ModifyMaxTime(TimeCondition timeCondition, int modifier) {
        this.timeCondition = timeCondition;
        this.modifier = modifier;
    }

    @Override
    public void run() {
        int newMax = (timeCondition.getMaxTime() + modifier) % 24000;
        timeCondition.setMaxTime(newMax);
    }
}
