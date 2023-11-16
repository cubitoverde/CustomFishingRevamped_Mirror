package com.gmail.cubitverde.CustomFishingRevamped.listeners;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.actions.SpeakerAction;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Speaker;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class PlayerChat implements Listener {
    @EventHandler
    private void setEvent(AsyncPlayerChatEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if (!CustomFishingRevamped.speakers.containsKey(uuid)) {
            return;
        }
        Speaker speaker = CustomFishingRevamped.speakers.get(uuid);
        event.setCancelled(true);

        for (SpeakerAction action : speaker.getActions()) {
            action.run(event.getMessage());
        }

        Bukkit.getScheduler().runTask(CustomFishingRevamped.plugin, () -> {
            new OpenMenu(speaker.getPlayer(), speaker.getMenu()).run();
        });
        CustomFishingRevamped.speakers.remove(uuid);
    }
}
