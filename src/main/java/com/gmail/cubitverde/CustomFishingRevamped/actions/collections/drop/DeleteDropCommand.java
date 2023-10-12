package com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;

public class DeleteDropCommand implements Action {
    private Drop drop;
    private String command;

    public DeleteDropCommand(Drop drop, String command) {
        this.drop = drop;
        this.command = command;
    }

    @Override
    public void run() {
        drop.getCommands().remove(command);
    }
}
