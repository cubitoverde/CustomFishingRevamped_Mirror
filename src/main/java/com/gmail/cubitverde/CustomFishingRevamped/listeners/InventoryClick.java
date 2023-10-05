package com.gmail.cubitverde.CustomFishingRevamped.listeners;

import com.gmail.cubitverde.CustomFishingRevamped.objects.Holder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryClick implements Listener {
    @EventHandler
    private void setEvent (InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getHolder() instanceof Holder) {
            event.setCancelled(true);
            Inventory inventory = event.getInventory();
            Holder holder = (Holder) inventory.getHolder();

            if (inventory.getType().equals(InventoryType.PLAYER)) {
                return;
            }

            if (!player.hasPermission("customfishing.admin")) {
                player.closeInventory();
                return;
            }

            holder.trigger(event.getSlot(), event.isLeftClick(), event.isRightClick());
            return;
        }
    }
}
