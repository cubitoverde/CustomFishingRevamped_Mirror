package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.LinkedList;

public class FishedUtils {
    public static LinkedList<Drop> GetDroppedItems(Player player, FishHook fishHook) {
        LootCollection globalLootCollection = GetRandomGlobalLootCollection();

        if (globalLootCollection == null) {
            return new LinkedList<>();
        }

        Collection collection = globalLootCollection.getCollection();
        if (collection.getEffect()) {
            Location location = fishHook.getLocation();
            Firework firework = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            fireworkMeta.setPower(0);
            fireworkMeta.addEffect(FireworkEffect.builder().withColor(MiscUtils.GetColorFromString(collection.getColor())).with(collection.getShape()).build());
            firework.setFireworkMeta(fireworkMeta);
            firework.detonate();
            CustomFishingRevamped.dropFireworks.add(firework);
        }

        LinkedList<Drop> droppedItems = GetRandomDropsFromLootCollection(globalLootCollection);

        return droppedItems;
    }

    public static LootCollection GetRandomGlobalLootCollection() {
        double random = Math.random();
        double current = 0;

        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            current += PluginUtils.GetDropChanceInGlobal(lootCollection);
            if (current > random) {
                return lootCollection;
            }
        }

        return null;
    }

    public static LinkedList<Drop> GetRandomDropsFromLootCollection(LootCollection lootCollection) {
        Collection collection = lootCollection.getCollection();

        LinkedList<Drop> drops = new LinkedList<>();

        for (int i = 0; i < lootCollection.getItemDrops(); i++) {
            double random = Math.random();
            double current = 0;

            for (Drop drop : collection.getItems()) {
                current += PluginUtils.GetDropChanceInCollection(drop, collection);
                if (current > random) {
                    drops.add(drop);
                    break;
                }
            }
        }

        return drops;
    }
}
