package com.gmail.cubitverde.CustomFishingRevamped.listeners;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.FishedUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class PlayerFish implements Listener {
    @EventHandler
    private void setEvent(PlayerFishEvent event) {
        Player player = event.getPlayer();
        FishHook fishHook = event.getHook();

        switch (event.getState()) {
            case FISHING: {
                fishHook.setWaitTime(100, 110);
                fishHook.setLureTime(20, 30);
                break;
            }
            case BITE: {
                break;
            }
            case CAUGHT_FISH: {
                if (!(event.getCaught() instanceof Item)) {
                    break;
                }

                Item item = (Item) event.getCaught();
                Location location = fishHook.getLocation();
                LinkedList<Drop> drops = FishedUtils.GetDroppedItems(player, fishHook);

                for (Drop drop : drops) {
                    Item itemClone = location.getWorld().dropItem(location, drop.getItem());
                    PluginUtils.CloneItem(item, itemClone);
                    itemClone.setVelocity(PluginUtils.GetFishedItemVelocityVector(player, fishHook));
                    itemClone.setItemStack(drop.getItem());
                }

                item.remove();

                break;
            }
            default: {

            }
        }
    }
}
