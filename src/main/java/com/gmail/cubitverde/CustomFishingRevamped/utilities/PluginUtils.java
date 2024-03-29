package com.gmail.cubitverde.CustomFishingRevamped.utilities;

import com.gmail.cubitverde.CustomFishingRevamped.CustomFishingRevamped;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class PluginUtils {
    public static ItemStack GetDropInfoItem(Drop drop, Collection collection) {
        ItemStack item = drop.getItem().clone();
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Weight: " + ChatColor.GRAY + drop.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInCollection(drop, collection)));

        lore.add(ChatColor.DARK_GREEN + "Commands: " + ChatColor.GRAY + drop.getCommands().size());

        if (itemMeta.getLore() != null) {
            lore.add(" ");
            lore.addAll(itemMeta.getLore());
        }

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static int GetCollectionTotalWeight(Collection collection) {
        int total = 0;
        for (Drop tempDrop : collection.getItems()) {
            total += tempDrop.getWeight();
        }

        return total;
    }

    public static double GetDropChanceInCollection(Drop drop, Collection collection) {
        int weight = drop.getWeight();
        int total = GetCollectionTotalWeight(collection);

        return ((double) weight) / ((double) total);
    }

    public static ItemStack GetCollectionDropInfoItem(Drop drop, Collection collection) {
        ItemStack item = MiscUtils.CreateItem(Material.PAPER, ChatColor.GREEN + "Information");
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Drop weight: " + ChatColor.GRAY + drop.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Total collection weight: " + ChatColor.GRAY + GetCollectionTotalWeight(collection));

        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInCollection(drop, collection)));

        lore.add(ChatColor.DARK_GREEN + "Commands: " + ChatColor.GRAY + drop.getCommands().size());

        lore.add(ChatColor.DARK_GREEN + "Has durability: " + ChatColor.GRAY + ItemHasDurability(drop.getItem()));
        lore.add(ChatColor.DARK_GREEN + "Is enchantable: " + ChatColor.GRAY + ItemIsEnchantable(drop.getItem()));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static boolean ItemHasDurability(ItemStack item) {
        return item.getType().getMaxDurability() > 1;
    }

    public static boolean ItemIsEnchantable(ItemStack item) {
        return Enchantment.DURABILITY.canEnchantItem(item);
    }

    public static ItemStack GetGlobalLootCollectionItem(LootCollection lootCollection) {
        Collection collection = lootCollection.getCollection();
        ItemStack item = MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName());
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "View items");
        lore.add(ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Settings");

        lore.add(ChatColor.GRAY + " ");

        lore.addAll(GetGlobalLootModifierInfoLore(lootCollection));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static LinkedList<String> GetGlobalLootModifierInfoLore(LootCollection lootCollection) {
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Collection weight: " + ChatColor.GRAY + lootCollection.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Total global loot weight: " + ChatColor.GRAY + GetGlobalTotalWeight());

        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInGlobal(lootCollection)));

        lore.add(ChatColor.DARK_GREEN + "Luck modifier: " + ChatColor.GRAY + GetIntModifierAsString(lootCollection.getLuckModifier()));
        lore.add(ChatColor.DARK_GREEN + "Items dropped: " + ChatColor.GRAY + lootCollection.getItemDrops());

        return lore;
    }

    public static int GetGlobalTotalWeight() {
        int total = 0;
        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            total += lootCollection.getWeight();
        }
        return total;
    }

    public static double GetDropChanceInGlobal(LootCollection lootCollection) {
        int weight = lootCollection.getWeight();
        int total = GetGlobalTotalWeight();

        return ((double) weight) / ((double) total);
    }

    public static String GetIntModifierAsString(int intModifier) {
        return intModifier > 0 ? "+" + intModifier : "" + intModifier;
    }

    public static String ColorIntModifier(int intModifier) {
        String text = GetIntModifierAsString(intModifier);
        if (intModifier > 0) {
            return ChatColor.GREEN + text;
        } else if (intModifier < 0) {
            return ChatColor.RED + text;
        } else {
            return ChatColor.WHITE + text;
        }
    }

    public static boolean CheckIfCollectionInList(Collection collection, LinkedList<Collection> collections) {
        int id = collection.getId();
        for (Collection tempCollection : collections) {
            if (tempCollection.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckIfCollectionInListLootCollections(Collection collection, LinkedList<LootCollection> lootCollections) {
        LinkedList<Collection> collections = new LinkedList<>();
        for (LootCollection lootCollection : lootCollections) {
            collections.add(lootCollection.getCollection());
        }

        return CheckIfCollectionInList(collection, collections);
    }

    public static LinkedList<Collection> GetGlobalCollections() {
        LinkedList<Collection> collections = new LinkedList<>();
        for (LootCollection lootCollection : CustomFishingRevamped.globalLootCollections) {
            collections.add(lootCollection.getCollection());
        }
        return collections;
    }

    public static void CloneItem(Item baseItem, Item newItem) {
        newItem.setItemStack(baseItem.getItemStack());
        newItem.setOwner(baseItem.getOwner());
        newItem.setPickupDelay(baseItem.getPickupDelay());
        newItem.setThrower(baseItem.getThrower());
        newItem.setUnlimitedLifetime(baseItem.isUnlimitedLifetime());

        newItem.setCustomNameVisible(baseItem.isCustomNameVisible());
        newItem.setFallDistance(baseItem.getFallDistance());
        newItem.setFireTicks(baseItem.getFireTicks());
        newItem.setFreezeTicks(baseItem.getFreezeTicks());
        newItem.setGlowing(baseItem.isGlowing());
        newItem.setGravity(baseItem.hasGravity());
        newItem.setInvulnerable(baseItem.isInvulnerable());
        newItem.setLastDamageCause(baseItem.getLastDamageCause());
        newItem.setPersistent(baseItem.isPersistent());
        newItem.setPortalCooldown(baseItem.getPortalCooldown());
        newItem.setSilent(baseItem.isSilent());
        newItem.setVelocity(baseItem.getVelocity());
        newItem.setVisibleByDefault(baseItem.isVisibleByDefault());
        newItem.setVisualFire(baseItem.isVisualFire());

        newItem.setCustomName(baseItem.getCustomName());

        newItem.setOp(baseItem.isOp());
    }

    public static Vector GetFishedItemVelocityVector(Player player, FishHook fishHook) {
        Location playerLoc = player.getLocation();
        Location fishLoc = fishHook.getLocation();

        double dX = playerLoc.getX() - fishLoc.getX();
        double dY = playerLoc.getY() - fishLoc.getY();
        double dZ = playerLoc.getZ() - fishLoc.getZ();

        double lambda = 0.15;

        return new Vector(dX, dY + 2, dZ).multiply(lambda);
    }

    public static Location GetAboveWaterFishHookLocation(Location location) {
        while (location.getWorld().getBlockAt(location).getType().equals(Material.WATER)) {
            location.add(0, 0.1, 0);
        }

        return location;
    }

    public static ItemStack GetConditionalBucketItem(ConditionalBucket bucket) {
        ItemStack item = MiscUtils.CreateItem(bucket.getIcon(), ChatColor.GREEN + bucket.getName());
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "View bucket");
        lore.add(ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Settings");

        lore.add(ChatColor.GRAY + " ");

        lore.addAll(GetConditionalBucketInfoLore(bucket));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static LinkedList<String> GetConditionalBucketInfoLore(ConditionalBucket bucket) {
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Conditions: " + ChatColor.GRAY + bucket.getConditions().size());
        lore.add(ChatColor.DARK_GREEN + "Collections: " + ChatColor.GRAY + bucket.getCollections().size());

        return lore;
    }

    public static ItemStack GetBucketCollectionItem(ConditionalBucket bucket, LootCollection lootCollection) {
        Collection collection = lootCollection.getCollection();
        ItemStack item = MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName());
        ItemMeta itemMeta = item.getItemMeta();
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "View items");
        lore.add(ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Settings");

        lore.add(ChatColor.GRAY + " ");

        lore.addAll(GetBucketCollectionInfoLore(bucket, lootCollection));

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static LinkedList<String> GetBucketCollectionInfoLore(ConditionalBucket bucket, LootCollection lootCollection) {
        LinkedList<String> lore = new LinkedList<>();

        lore.add(ChatColor.DARK_GREEN + "Collection weight: " + ChatColor.GRAY + lootCollection.getWeight());
        lore.add(ChatColor.DARK_GREEN + "Total bucket weight: " + ChatColor.GRAY + GetBucketTotalWeight(bucket));

        lore.add(ChatColor.DARK_GREEN + "Drop chance: " + ChatColor.WHITE + new DecimalFormat("#%.##").format(GetDropChanceInBucket(lootCollection, bucket)));

        lore.add(ChatColor.DARK_GREEN + "Luck modifier: " + ChatColor.GRAY + GetIntModifierAsString(lootCollection.getLuckModifier()));
        lore.add(ChatColor.DARK_GREEN + "Items dropped: " + ChatColor.GRAY + lootCollection.getItemDrops());

        return lore;
    }

    public static int GetBucketTotalWeight(ConditionalBucket bucket) {
        int total = 0;
        for (LootCollection lootCollection : bucket.getCollections()) {
            total += lootCollection.getWeight();
        }
        return total;
    }

    public static double GetDropChanceInBucket(LootCollection lootCollection, ConditionalBucket bucket) {
        int weight = lootCollection.getWeight();
        int total = GetBucketTotalWeight(bucket);

        return ((double) weight) / ((double) total);
    }
}
