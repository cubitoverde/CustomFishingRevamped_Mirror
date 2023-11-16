package com.gmail.cubitverde.CustomFishingRevamped.listeners;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamaged implements Listener {
    @EventHandler
    private void setEvent (EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Firework) {
            Firework firework = (Firework) event.getDamager();
            if (CustomFishingRevamped.dropFireworks.contains(firework)) {
                event.setCancelled(true);
            }
        }
    }
}
