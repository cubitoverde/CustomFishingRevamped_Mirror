package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;

public class LootCondition {
    private Condition condition;
    private boolean isActive;
    private boolean isWhitelist;

    public LootCondition(Condition condition) {
        this.condition = condition;
        this.isActive = false;
        this.isWhitelist = true;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getWhitelist() {
        return isWhitelist;
    }

    public void setWhitelist(boolean whitelist) {
        isWhitelist = whitelist;
    }
}
