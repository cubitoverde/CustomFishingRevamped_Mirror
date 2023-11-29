package com.gmail.cubitverde.CustomFishingRevamped.objects;

import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;

public class LootCondition {
    private Condition condition;
    private boolean isEnabled;
    private boolean isWhitelist;

    public LootCondition(Condition condition) {
        this.condition = condition;
        this.isEnabled = true;
        this.isWhitelist = true;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public boolean isConditionMet() {
        return condition.isMet();
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void toggleEnabled() {
        isEnabled = !isEnabled;
    }

    public boolean getWhitelist() {
        return isWhitelist;
    }

    public void setWhitelist(boolean whitelist) {
        isWhitelist = whitelist;
    }

    public void toggleWhitelist() {
        isWhitelist = !isWhitelist;
    }
}
