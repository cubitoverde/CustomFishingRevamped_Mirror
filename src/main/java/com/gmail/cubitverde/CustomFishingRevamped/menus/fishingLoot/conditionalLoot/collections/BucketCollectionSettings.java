package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionDropsAmount;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionLuckModifier;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.ChangeLootCollectionWeight;
import com.gmail.cubitverde.CustomFishingRevamped.actions.lootCollections.conditional.RemoveBucketCollection;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCollection;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class BucketCollectionSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCollection lootCollection;

    public BucketCollectionSettings(Player player, ConditionalBucket bucket, LootCollection lootCollection) {
        this.player = player;
        this.bucket = bucket;
        this.lootCollection = lootCollection;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();
        Collection collection = lootCollection.getCollection();

        {
            Icon icon = new Icon(MiscUtils.CreateItem(collection.getIcon(), ChatColor.GREEN + collection.getName()));
            icons.put(10, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.PAPER, ChatColor.GREEN + "Information",
                    PluginUtils.GetBucketCollectionInfoLore(bucket, lootCollection)));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.CLOCK, ChatColor.GREEN + "Change weight",
                    ChatColor.DARK_GREEN + "Current weight: " + ChatColor.GRAY + lootCollection.getWeight()));
            icon.addAction(new ChangeLootCollectionWeight(player, lootCollection, this));
            icons.put(13, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.GOLD_INGOT, ChatColor.GREEN + "Luck modifier",
                    ChatColor.DARK_GREEN + "Current modifier: " + ChatColor.WHITE + PluginUtils.GetIntModifierAsString(lootCollection.getLuckModifier()),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Add 1 to the modifier",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Remove 1 from the modifier",
                    " ",
                    ChatColor.GRAY + "Each level of the Luck of the Sea enchantment",
                    ChatColor.GRAY + "will add or remove this modifier to the weight"));
            icon.addLAction(new ChangeLootCollectionLuckModifier(lootCollection, 1));
            icon.addRAction(new ChangeLootCollectionLuckModifier(lootCollection, -1));
            icon.addAction(new OpenMenu(player, this));
            icons.put(15, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.ITEM_FRAME, ChatColor.GREEN + "Dropped items amount",
                    ChatColor.DARK_GREEN + "Current amount: " + ChatColor.WHITE + lootCollection.getItemDrops(),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Add 1 to the amount",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Remove 1 from the amount",
                    " ",
                    ChatColor.GRAY + "The total amount of items that will",
                    ChatColor.GRAY + "be selected from this collection."));
            icon.addLAction(new ChangeLootCollectionDropsAmount(lootCollection, 1));
            icon.addRAction(new ChangeLootCollectionDropsAmount(lootCollection, -1));
            icon.addAction(new OpenMenu(player, this));
            icons.put(16, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BARRIER, ChatColor.RED + "Remove collection",
                    ChatColor.DARK_RED + "Shift click to remove this collection"));
            icon.addShiftAction(new RemoveBucketCollection(bucket, lootCollection));
            icon.addShiftAction(new OpenMenu(player, new BucketCollections(player, bucket)));
            icons.put(19, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Collection Settings]", 4*9, new BucketCollections(player, bucket));
    }
}
